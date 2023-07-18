package sergei.webshop.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {

    private Long id;
    private Date creationDate;
    private String paymentState;
    private double totalSum;
    private List<OrderRowDTO> orderRow;
    private PersonDTO person;

}
