package sergei.webshop.dto;

import lombok.Data;
import sergei.webshop.entity.PaymentStatus;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {

    private Long id;
    private Date creationDate;
    private PaymentStatus paymentState;
    private double totalSum;
    private List<OrderRowsDTO> orderRows;
    private PersonDTO person;

}
