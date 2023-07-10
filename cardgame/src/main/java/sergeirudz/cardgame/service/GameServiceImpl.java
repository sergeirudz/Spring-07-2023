package sergeirudz.cardgame.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sergeirudz.cardgame.dto.GameDTO;
import sergeirudz.cardgame.dto.GameStatus;
import sergeirudz.cardgame.entity.Card;
import sergeirudz.cardgame.entity.CardRank;
import sergeirudz.cardgame.entity.CardSuit;
import sergeirudz.cardgame.entity.Game;
import sergeirudz.cardgame.repository.CardRepository;
import sergeirudz.cardgame.repository.GameRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static jakarta.persistence.GenerationType.UUID;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public GameDTO game(GameDTO gameDTO) {

        // POPULATE DATABASE WITH CARDS
        if (cardRepository.count() == 0) {
            List<Card> cards = new ArrayList<>();

            for (CardSuit suit : CardSuit.values()) {
                for (CardRank rank : CardRank.values()) {
                    int value = rank.getValue();
                    Card card = new Card(rank, suit, value);
                    cards.add(card);
                }
            }

            cardRepository.saveAll(cards);

            log.info("Cards have been added to the database.");
        } else {
            log.info("The database already contains cards.");
        }


        /* Send card
        {
        "gameId": 1,
        "playerCard": {
        "rank": "ACE",
        "suit": "SPADES",
        "value": 10
         },
        "gameStatus": "IN_PROGRESS"
        }  */
        if(gameDTO.getGameStatus() == GameStatus.IN_PROGRESS && gameDTO.getPlayerCard() != null) {
            log.info("Player Sent Card");
            Game game = gameRepository.findById(gameDTO.getGameId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid gameId"));
            Card baseCard = game.getBaseCard();
            if (gameDTO.getPlayerCard().getValue() > baseCard.getValue()) {
                // Update playerScore
                int newPlayerScore = game.getPlayerScore() + 1;
                game.setPlayerScore(newPlayerScore);
                gameRepository.save(game);
                log.info("newPlayerScore +1 : " + newPlayerScore);
            }
        } else {
            log.info("gameStatus is not IN_PROGRESS.");
        }


        // START A NEW GAME
        /*
        {
        "gameStatus": "START"
        }
        */
        if (gameDTO.getGameStatus() == GameStatus.START) {
            // Retrieve a random card from the database
            List<Card> allCards = cardRepository.findAll();
            int totalCards = allCards.size();
            int randomIndex = new Random().nextInt(totalCards);
            Card randomCard = allCards.get(randomIndex);

            // Create a new game with the random card
            Game game = new Game();
            game.setPlayerScore(0);
            game.setComputerScore(0);
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setCountdownTime(LocalDateTime.now());
            game.setBaseCard(randomCard);
            gameRepository.save(game);

            return modelMapper.map(game, GameDTO.class);
        } else {
            // GameStatus is not "START", return the provided gameDTO
//            log.info("gameStatus: START was not provided.");
            return gameDTO;
        }

    }
}
