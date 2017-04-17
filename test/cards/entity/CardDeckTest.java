package cards.entity;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andrew
 */
public class CardDeckTest {
    
    public CardDeckTest() {
    }
    
    @Test
    public void addCardToDeckTest() {
        CardDeck cardDeck = new CardDeck();
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 53; i++) {
            cards.add(new Card());
        }
        cardDeck.setCards(cards);
        assertEquals(cards.size(), 53);
        cardDeck.addCardToDeck(new Card());
        assertEquals(cards.size(), 54);
        cardDeck.addCardToDeck(new Card());
        assertEquals(cards.size(), 54);
    }
    
    @Test 
    public void getRandomCardFromDeckTest() {
        CardDeck cardDeck = new CardDeck();
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 54; i++) {
            cards.add(new Card());
        }
        cardDeck.setCards(cards);
        assertEquals(cards.size(), 54);
        Card card = cardDeck.getRandomCardFromDeck();
        assertNotNull(card);
        assertEquals(cards.size(), 53);
    }
    
}
