package cards.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author andrew
 */
public class CardDeck {
    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
    
    public Card getRandomCardFromDeck() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, this.cards.size());
        Card card = this.cards.get(randomNum);
        this.cards.remove(randomNum);
        return card;
    }
    
    public void addCardToDeck(Card card) {
        if (this.cards.size() < 54) {
            this.cards.add(card);
        }
    }
    
    public List<Card> getTo5CardsFromDeck() {
        List<Card> cardsFromDeck = new ArrayList<>();
        byte num = 0;
        while (num < 5 && this.cards.size() > 0) {
            cardsFromDeck.add(getRandomCardFromDeck());
            num++;
        }
        return cardsFromDeck;
    }
    
    public void getNewCardDeck() {
        this.cards = new ArrayList<>();
        this.cards.add(new Card(Suit.HEARTS, Range._2, 0));
        this.cards.add(new Card(Suit.HEARTS, Range._3, 1));
        this.cards.add(new Card(Suit.HEARTS, Range._4, 2));
        this.cards.add(new Card(Suit.HEARTS, Range._5, 3));
        this.cards.add(new Card(Suit.HEARTS, Range._6, 4));
        this.cards.add(new Card(Suit.HEARTS, Range._7, 5));
        this.cards.add(new Card(Suit.HEARTS, Range._8, 6));
        this.cards.add(new Card(Suit.HEARTS, Range._9, 7));
        this.cards.add(new Card(Suit.HEARTS, Range._10, 8));
        this.cards.add(new Card(Suit.HEARTS, Range.JACK, 9));
        this.cards.add(new Card(Suit.HEARTS, Range.LADY, 10));
        this.cards.add(new Card(Suit.HEARTS, Range.KING, 11));
        this.cards.add(new Card(Suit.HEARTS, Range.ACE, 12));
        
        this.cards.add(new Card(Suit.DIAMONDS, Range._2, 13));
        this.cards.add(new Card(Suit.DIAMONDS, Range._3, 14));
        this.cards.add(new Card(Suit.DIAMONDS, Range._4, 15));
        this.cards.add(new Card(Suit.DIAMONDS, Range._5, 16));
        this.cards.add(new Card(Suit.DIAMONDS, Range._6, 17));
        this.cards.add(new Card(Suit.DIAMONDS, Range._7, 18));
        this.cards.add(new Card(Suit.DIAMONDS, Range._8, 19));
        this.cards.add(new Card(Suit.DIAMONDS, Range._9, 20));
        this.cards.add(new Card(Suit.DIAMONDS, Range._10, 21));
        this.cards.add(new Card(Suit.DIAMONDS, Range.JACK, 22));
        this.cards.add(new Card(Suit.DIAMONDS, Range.LADY, 23));
        this.cards.add(new Card(Suit.DIAMONDS, Range.KING, 24));
        this.cards.add(new Card(Suit.DIAMONDS, Range.ACE, 25));
        
        this.cards.add(new Card(Suit.SPADES, Range._2, 26));
        this.cards.add(new Card(Suit.SPADES, Range._3, 27));
        this.cards.add(new Card(Suit.SPADES, Range._4, 28));
        this.cards.add(new Card(Suit.SPADES, Range._5, 29));
        this.cards.add(new Card(Suit.SPADES, Range._6, 30));
        this.cards.add(new Card(Suit.SPADES, Range._7, 31));
        this.cards.add(new Card(Suit.SPADES, Range._8, 32));
        this.cards.add(new Card(Suit.SPADES, Range._9, 33));
        this.cards.add(new Card(Suit.SPADES, Range._10, 34));
        this.cards.add(new Card(Suit.SPADES, Range.JACK, 35));
        this.cards.add(new Card(Suit.SPADES, Range.LADY, 36));
        this.cards.add(new Card(Suit.SPADES, Range.KING, 37));
        this.cards.add(new Card(Suit.SPADES, Range.ACE, 38));
        
        this.cards.add(new Card(Suit.CLUBS, Range._2, 39));
        this.cards.add(new Card(Suit.CLUBS, Range._3, 40));
        this.cards.add(new Card(Suit.CLUBS, Range._4, 41));
        this.cards.add(new Card(Suit.CLUBS, Range._5, 42));
        this.cards.add(new Card(Suit.CLUBS, Range._6, 43));
        this.cards.add(new Card(Suit.CLUBS, Range._7, 44));
        this.cards.add(new Card(Suit.CLUBS, Range._8, 45));
        this.cards.add(new Card(Suit.CLUBS, Range._9, 46));
        this.cards.add(new Card(Suit.CLUBS, Range._10, 47));
        this.cards.add(new Card(Suit.CLUBS, Range.JACK, 48));
        this.cards.add(new Card(Suit.CLUBS, Range.LADY, 49));
        this.cards.add(new Card(Suit.CLUBS, Range.KING, 50));
        this.cards.add(new Card(Suit.CLUBS, Range.ACE, 51));
        this.cards.add(new Card(Suit.NOSUIT, Range.BLACK_JOKER, 52));
        this.cards.add(new Card(Suit.NOSUIT, Range.RED_JOKER, 53));
    }
}
