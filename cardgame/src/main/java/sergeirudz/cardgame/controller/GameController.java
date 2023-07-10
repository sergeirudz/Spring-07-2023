package sergeirudz.cardgame.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sergeirudz.cardgame.dto.GameDTO;
import sergeirudz.cardgame.service.GameService;

@RequiredArgsConstructor
@RestController
public class GameController {

    private final GameService gameService;

    @PostMapping("game") // http://localhost:8080/game
    public GameDTO game(
            @RequestBody GameDTO gameDTO
    ) {
        {
            return gameService.game(gameDTO);
        }

    }
}
