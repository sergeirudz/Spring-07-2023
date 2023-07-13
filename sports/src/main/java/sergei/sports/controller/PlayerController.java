package sergei.sports.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sergei.sports.dto.GameScoreDTO;
import sergei.sports.dto.PlayerDTO;
import sergei.sports.service.PlayerService;

@RequiredArgsConstructor
@RestController
public class PlayerController {

    private final PlayerService playerService;

    /*
    // http://localhost:8080/player/add
    {
    "name": "John Smith",
    "age": 33,
    "country": "USA"
    }
    */
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


    @GetMapping("player/{playerId}/score")
    public int getTotalPlayerScore(
            @PathVariable Long playerId
    ) {
        {
            return playerService.getTotalPlayerScore(playerId);
        }
    }
}
