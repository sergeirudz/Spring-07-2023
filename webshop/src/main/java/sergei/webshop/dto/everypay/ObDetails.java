package sergei.webshop.dto.everypay;

import lombok.Data;

@Data
public class ObDetails {
    public Object error;
    public String debtor_iban;
    public String creditor_iban;
    public String ob_payment_reference;
    public String ob_payment_state;
}
