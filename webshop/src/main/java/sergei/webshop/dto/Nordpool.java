package sergei.webshop.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Nordpool {
    public boolean success;
    public CountryPrices data;
}

@Data
class CountryPrices {
    public ArrayList<TimestampPrice> ee;
    public ArrayList<TimestampPrice> fi;
    public ArrayList<TimestampPrice> lv;
    public ArrayList<TimestampPrice> lt;
}

@Data
class TimestampPrice {
    public int timestamp;
    public double price;
}

