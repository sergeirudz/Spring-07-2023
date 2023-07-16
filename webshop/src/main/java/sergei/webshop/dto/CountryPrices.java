package sergei.webshop.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CountryPrices {
    public ArrayList<TimestampPrice> ee;
    public ArrayList<TimestampPrice> fi;
    public ArrayList<TimestampPrice> lv;
    public ArrayList<TimestampPrice> lt;
}
