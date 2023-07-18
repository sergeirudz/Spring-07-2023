package sergei.webshop.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sergei.webshop.dto.OrderDTO;
import sergei.webshop.dto.OrderRowDTO;
import sergei.webshop.entity.Order;
import sergei.webshop.entity.OrderRow;
import sergei.webshop.entity.Person;
import sergei.webshop.entity.Product;
import sergei.webshop.repository.OrderRepository;
import sergei.webshop.repository.OrderRowRepository;
import sergei.webshop.repository.PersonRepository;
import sergei.webshop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRowRepository orderRowRepository;

    @Override
    public ResponseEntity<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDTO> orderDTOs = new ArrayList<>();

        for (Order order : orders) {
            OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
            orderDTOs.add(orderDTO);
        }

        return new ResponseEntity(orderDTOs, HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<OrderDTO> addOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setCreationDate(new Date());
        order.setPaymentState(orderDTO.getPaymentState());

        double totalSum = 0;

        Person person = personRepository.findById(orderDTO.getPerson().getId()).orElse(null);
        if (person == null) {
            throw new IllegalArgumentException("Person with the given id does not exist.");
        }
        order.setPerson(person);

        List<OrderRowDTO> orderRowDTOs = orderDTO.getOrderRow();

        if (orderRowDTOs != null && !orderRowDTOs.isEmpty()) {
            List<OrderRow> orderRows = new ArrayList<>();

            for (OrderRowDTO orderRowDTO : orderRowDTOs) {
                Product product = productRepository.findById(orderRowDTO.getProduct().getId()).orElse(null);
                if (product == null) {
                    throw new IllegalArgumentException("Product with the given id does not exist.");
                }

                OrderRow orderRow = new OrderRow();
                orderRow.setProduct(product);
                orderRow.setQuantity(orderRowDTO.getQuantity());
                orderRow.setOrders(order);
                orderRows.add(orderRow);
                orderRowRepository.save(orderRow);

                // Calculate the subtotal for each order row and add it to the total sum
                double subtotal = product.getPrice() * orderRowDTO.getQuantity();
                totalSum += subtotal;
            }

        }
        order.setTotalSum(totalSum);

        orderRepository.save(order);

        OrderDTO createdOrderDTO = modelMapper.map(order, OrderDTO.class);

        return new ResponseEntity<>(createdOrderDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<OrderDTO> deleteOrder(Long id) {
        orderRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OrderDTO> getOrder(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }
}
