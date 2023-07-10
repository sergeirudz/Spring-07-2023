package sergeirudz.cardgame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sergeirudz.cardgame.entity.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
}
