package sergei.sports.service;

import sergei.sports.dto.GameScoreDTO;
import sergei.sports.dto.PlayerDTO;

public interface PlayerService {

    PlayerDTO addPlayer(PlayerDTO playerDTO);

    String addScore(GameScoreDTO gameScoreDTO);

    int getTotalPlayerScore(Long playerId);
}
