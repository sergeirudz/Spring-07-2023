package sergeirudz.cardgame.entity;

import jakarta.persistence.*;
import lombok.Data;
import sergeirudz.cardgame.dto.GameStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "game")
@Data
public class Game {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "player_score")
    private int playerScore;

    @Column(name = "computer_score")
    private int computerScore;

    @Column(name = "game_status")
    private GameStatus gameStatus;

    @Column(name = "countdown_time")
    private LocalDateTime countdownTime;

//    @Column(name = "base_card")
@ManyToOne
@JoinColumn(name = "card_id")
private Card baseCard;
}

