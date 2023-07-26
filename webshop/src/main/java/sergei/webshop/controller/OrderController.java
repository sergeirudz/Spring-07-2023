package sergei.webshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import sergei.webshop.dto.OrderDTO;
import sergei.webshop.service.OrderService;
import sergei.webshop.service.PaymentService;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    private final PaymentService paymentService;

    @GetMapping("orders")
    public ResponseEntity<OrderDTO> getOrders() {
        return orderService.getAllOrders();
    }

    @DeleteMapping("orders/{id}")
    public ResponseEntity<OrderDTO> deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }

    @GetMapping("orders/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @PostMapping("orders")  // TODO get user from JWT not from request body
    public ResponseEntity<String> createPayOrder(@RequestBody OrderDTO orderDTO) throws Exception {
        return orderService.createPayOrder(orderDTO);
    }

    @GetMapping("check-payment/{paymentReference}")
    public ResponseEntity<Boolean> checkPayment(@PathVariable String paymentReference) {
        return paymentService.checkPayment(paymentReference);
    }
}
