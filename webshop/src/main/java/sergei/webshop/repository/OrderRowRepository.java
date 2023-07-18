package sergei.webshop.repository;

import sergei.webshop.entity.OrderRow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRowRepository extends JpaRepository<OrderRow, Long> {
}
