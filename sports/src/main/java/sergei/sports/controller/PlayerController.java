package sergei.sports.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sergei.sports.dto.GameScoreDTO;
import sergei.sports.dto.PlayerDTO;
import sergei.sports.service.PlayerService;

@RequiredArgsConstructor
@RestController
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping("player/add")
    public PlayerDTO addPlayer(
            @RequestBody PlayerDTO playerDTO
    ) {
        {
            return playerService.addPlayer(playerDTO);
        }
    }


    /* http://localhost:8080/player/score/add
    {
    "playerId": 1,
    "playerScore": 10,
    "decathlonEvent": "EVENT_100M"
    }
    * */
    @PostMapping("player/score/add")
    public String addScore(
            @RequestBody GameScoreDTO gameScoreDTO
    ) {
        {
            return playerService.addScore(gameScoreDTO);
        }
    }
}
