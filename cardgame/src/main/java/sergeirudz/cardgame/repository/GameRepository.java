package sergeirudz.cardgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sergeirudz.cardgame.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
}
