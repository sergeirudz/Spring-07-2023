package sergei.webshop.dto.ParcelMachines;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SmartPostPM {
    private int place_id;
    private String name;
    private String city;
    private String address;
    private String opened;
    private int group_id;
    private String group_name;
    private int group_sort;
    private String description;
    private int active;
    private Object inactive_reason;
    private String created_date;
    private String updated_date;
}
