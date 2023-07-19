package sergei.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sergei.webshop.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
