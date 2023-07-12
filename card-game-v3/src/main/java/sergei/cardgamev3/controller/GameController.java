package sergei.cardgamev3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sergei.cardgamev3.model.Card;

import java.time.LocalDateTime;

@RestController
public class GameController {
    LocalDateTime roundStartTime;
    Card baseCard;
    int correctAnswers;
    boolean guessed;

    @GetMapping("start")
    public Card startGame() {
        roundStartTime = LocalDateTime.now();
        guessed = false;
        if (baseCard == null) {
            baseCard = new Card();
            correctAnswers = 0;
        }
        return baseCard;
    }

    @GetMapping("guess/{input}")
    public String guess(
            @PathVariable String input
    ) {
        if (guessed) {
            return "ALREADY_GUESSED";
        }
        guessed = true;
        LocalDateTime guessTime = LocalDateTime.now();
        if (guessTime.isAfter(roundStartTime.plusSeconds(10))) {
            return "TIME_OUT";
        }

        Card newCard = new Card();

        if (input.equals("lower") && baseCard.getValue() > newCard.getValue() ||
                input.equals("equal") && baseCard.getValue() == newCard.getValue() ||
                input.equals("higher") && baseCard.getValue() < newCard.getValue()
        ) {
            correctAnswers++;
            baseCard = newCard;
            return "CORRECT!";
        }

        baseCard = newCard;

        return "WRONG";
    }
}
