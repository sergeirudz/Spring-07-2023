package sergei.webshop.dto;

import lombok.Data;

import java.util.List;

@Data
public class NordpoolResult {

    List<TimestampPrice> countryPrices;
    Nordpool nordpool;
}
