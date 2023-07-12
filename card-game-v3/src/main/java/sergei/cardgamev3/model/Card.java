package sergei.cardgamev3.model;

import lombok.Data;

@Data
public class Card {
    private Suit suit;
    private Rank rank;
    private int value;

    // temporary default values
    public Card(){
        this.suit = Suit.getRandom();
        this.rank = Rank.getRandom();
        this.value = Rank.NINE.getValue();
    }
}


