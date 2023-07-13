package sergei.sports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sergei.sports.entity.GameScore;

public interface GameScoreRepository extends JpaRepository<GameScore, Long> {

    int getTotalPointsByPlayerId(Long playerId);


    @Query("SELECT SUM(gs.playerPoints) FROM GameScore gs WHERE gs.player.id = :playerId")
    Integer calculateTotalPointsByPlayerId(Long playerId);
}
