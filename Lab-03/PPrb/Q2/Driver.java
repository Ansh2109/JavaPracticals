import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();
        Card[] toAdd = {
            new Card("Ace", "Spades"),
            new Card("King", "Hearts"),
            new Card("Ace", "Spades")   // duplicate
        };

        for (Card c : toAdd) {
            boolean isDuplicate = false;
            for (Card existing : cards) {
                if (existing.equals(c)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                System.out.println("Duplicate found: " + c);
                break; // stop at first repeat, as spec says "the first time"
            }
            cards.add(c);
        }
    }
}