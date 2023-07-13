package sergei.sports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sergei.sports.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
