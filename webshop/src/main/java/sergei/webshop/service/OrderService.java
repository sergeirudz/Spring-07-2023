package sergei.webshop.service;

import org.springframework.http.ResponseEntity;
import sergei.webshop.dto.OrderDTO;

public interface OrderService {
    ResponseEntity<OrderDTO> getAllOrders();

    ResponseEntity<OrderDTO> addOrder(OrderDTO orderDTO);

    ResponseEntity<OrderDTO> deleteOrder(Long id);

    ResponseEntity<OrderDTO> getOrder(Long id);
}
