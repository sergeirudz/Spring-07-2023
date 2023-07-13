package sergei.sports.dto;

import lombok.Data;
import sergei.sports.entity.DecathlonEvent;

@Data
public class GameScoreDTO {

    private Long playerId;
    private double playerScore;
    private DecathlonEvent decathlonEvent;
}
