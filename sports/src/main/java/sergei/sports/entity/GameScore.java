package sergei.sports.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "game_score")
@Data
public class GameScore {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "game_score_id")
    private Long gameId;

    @Column(name = "player_score")
    private double playerScore;

    @Column(name = "player_points")
    private int playerPoints;

    @Column(name = "decathlon_event")
    private DecathlonEvent decathlonEvent;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
}
