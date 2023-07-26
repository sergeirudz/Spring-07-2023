package sergei.webshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sergei.webshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product>  findAllByOrderById(Pageable pageable);
    List<Product> findAllByOrderById();
}
