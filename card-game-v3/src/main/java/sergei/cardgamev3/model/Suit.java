package sergei.cardgamev3.model;

import java.util.Random;

public enum Suit {
    HEART, DIAMOND, CLUB, SPADE;

    public static Suit getRandom() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
