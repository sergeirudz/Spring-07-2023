package sergei.sports.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sergei.sports.dto.GameScoreDTO;
import sergei.sports.dto.PlayerDTO;
import sergei.sports.entity.DecathlonEvent;
import sergei.sports.entity.GameScore;
import sergei.sports.entity.Player;
import sergei.sports.repository.GameScoreRepository;
import sergei.sports.repository.PlayerRepository;

import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameScoreRepository gameScoreRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PlayerDTO addPlayer(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setPlayerName(playerDTO.getName());
        player.setPlayerCountry(playerDTO.getCountry());
        player.setPlayerAge(playerDTO.getAge());

        playerRepository.save(player);

        return modelMapper.map(player, PlayerDTO.class);
    }

    @Override
    public String addScore(GameScoreDTO gameScoreDTO) {
        // verify here https://www.sportcalculators.com/decathlon-calculator
        int eventPoints = DecathlonPointsCalculator.calculateEventPoints(gameScoreDTO.getPlayerScore(), gameScoreDTO.getDecathlonEvent());

        Player player = playerRepository.findById(gameScoreDTO.getPlayerId()).orElseThrow(() -> new RuntimeException("Player not found"));

        GameScore gameScore = new GameScore();
        gameScore.setPlayer(player);
        gameScore.setPlayerPoints(eventPoints);
        gameScore.setDecathlonEvent(gameScoreDTO.getDecathlonEvent());
        gameScore.setPlayerScore(gameScoreDTO.getPlayerScore());
        gameScoreRepository.save(gameScore);

        int totalPoints = gameScoreRepository.calculateTotalPointsByPlayerId(gameScoreDTO.getPlayerId());

        return eventPoints + " points added. " + "Player has now a total of " + totalPoints +  " points.";
    }

    @Override
    public int getTotalPlayerScore(Long playerId) {
        return gameScoreRepository.calculateTotalPointsByPlayerId(playerId);
    }


    private static class DecathlonPointsCalculator {
        public static int calculateEventPoints(double timeInSeconds, DecathlonEvent event) {
            double a = event.getA();
            double b = event.getB();
            double c = event.getC();

            double points = switch (event) {
                case EVENT_100M, EVENT_400M, EVENT_1500M -> a * Math.pow((b - timeInSeconds), c);
                case EVENT_110M_HURDLES, EVENT_DISCUS_THROW, EVENT_POLE_VAULT,EVENT_JAVELIN_THROW, EVENT_LONG_JUMP, EVENT_SHOT_PUT, EVENT_HIGH_JUMP -> a * Math.pow((timeInSeconds - b), c);
                default -> throw new IllegalStateException("Unexpected event category: " + event);
            };

            return  (int) Math.round(points);
        }
    }

}

