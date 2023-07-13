package sergei.sports.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "player")
@Data
public class Player {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "player_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "player_age")
    private int playerAge;

    @Column(name = "player_country")
    private String playerCountry;
}
