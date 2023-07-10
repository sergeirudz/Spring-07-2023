package sergeirudz.cardgame.dto;

import lombok.Data;
import sergeirudz.cardgame.entity.Card;

import java.time.LocalDateTime;

@Data
public class GameDTO {

    private Long gameId;
    private int playerScore;
    private int computerScore;
    private GameStatus gameStatus;
    private LocalDateTime countdownTime;
    private String baseCard;
    private Card playerCard;
}


