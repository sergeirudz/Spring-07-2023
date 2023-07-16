package sergei.webshop.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Nordpool {
    public boolean success;
    public CountryPrices data;

    public Object getCountryPrices() {
        return data;
    }
}

