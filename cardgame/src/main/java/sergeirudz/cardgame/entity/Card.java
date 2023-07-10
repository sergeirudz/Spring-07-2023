package sergeirudz.cardgame.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cards")
@Data
public class Card {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "card_id", nullable = false, unique = true)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_rank")
    private CardRank rank;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_suit")
    private CardSuit suit;

    @Column(name = "card_value")
    private int value;

    public Card() {
        // Default constructor for JPA
    }

    public Card(CardRank rank, CardSuit suit, int value) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
    }

}
