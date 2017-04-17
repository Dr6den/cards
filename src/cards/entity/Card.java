package cards.entity;

import java.io.File;
import java.util.Objects;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author andrew
 */
public class Card {
    private ImageView backSide;
    private ImageView frontSide;
    private Suit suit;
    private Range range;
    private int numberInDeck;

    public Card() {
    }

    public Card(Suit suit, Range range, int numberInDeck) {
        this.numberInDeck = numberInDeck;
        this.suit = suit;
        this.range = range;
        File backSideFile = new File("resources/images/PNG-cards-1.3/back_side.jpg");
        Image image = new Image(backSideFile.toURI().toString());
        this.backSide = new ImageView(image);
        this.frontSide = getFrontImage(suit, range);
    }

    public int getNumberInDeck() {
        return numberInDeck;
    }

    public void setNumberInDeck(int numberInDeck) {
        this.numberInDeck = numberInDeck;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.backSide);
        hash = 23 * hash + Objects.hashCode(this.frontSide);
        hash = 23 * hash + Objects.hashCode(this.suit);
        hash = 23 * hash + Objects.hashCode(this.range);
        hash = 23 * hash + this.numberInDeck;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.numberInDeck != other.numberInDeck) {
            return false;
        }
        if (!Objects.equals(this.backSide, other.backSide)) {
            return false;
        }
        if (!Objects.equals(this.frontSide, other.frontSide)) {
            return false;
        }
        if (this.suit != other.suit) {
            return false;
        }
        if (this.range != other.range) {
            return false;
        }
        return true;
    }

    private static ImageView getFrontImage(Suit suit, Range range) {
        StringBuilder url = new StringBuilder("resources/images/PNG-cards-1.3/");

        switch (suit) {
            case NOSUIT:
                switch (range) {
            case RED_JOKER:
                url.append("red_joker.png");
                break;
            case BLACK_JOKER:
                url.append("black_joker.png");
                break;
            }
            case HEARTS:
                switch (range) {
                    case _2:
                        url.append("2_of_hearts.png");
                        break;
                    case _3:
                        url.append("3_of_hearts.png");
                        break;
                    case _4:
                        url.append("4_of_hearts.png");
                        break;
                    case _5:
                        url.append("5_of_hearts.png");
                        break;
                    case _6:
                        url.append("6_of_hearts.png");
                        break;
                    case _7:
                        url.append("7_of_hearts.png");
                        break;
                    case _8:
                        url.append("8_of_hearts.png");
                        break;
                    case _9:
                        url.append("9_of_hearts.png");
                        break;
                    case _10:
                        url.append("10_of_hearts.png");
                        break;
                    case JACK:
                        url.append("jack_of_hearts2.png");
                        break;
                    case LADY:
                        url.append("queen_of_hearts2.png");
                        break;
                    case KING:
                        url.append("king_of_hearts2.png");
                        break;
                    case ACE:
                        url.append("ace_of_hearts.png");
                        break;
                }
                break;
            case SPADES:
                switch (range) {
                    case _2:
                        url.append("2_of_spades.png");
                        break;
                    case _3:
                        url.append("3_of_spades.png");
                        break;
                    case _4:
                        url.append("4_of_spades.png");
                        break;
                    case _5:
                        url.append("5_of_spades.png");
                        break;
                    case _6:
                        url.append("6_of_spades.png");
                        break;
                    case _7:
                        url.append("7_of_spades.png");
                        break;
                    case _8:
                        url.append("8_of_spades.png");
                        break;
                    case _9:
                        url.append("9_of_spades.png");
                        break;
                    case _10:
                        url.append("10_of_spades.png");
                        break;
                    case JACK:
                        url.append("jack_of_spades2.png");
                        break;
                    case LADY:
                        url.append("queen_of_spades2.png");
                        break;
                    case KING:
                        url.append("king_of_spades2.png");
                        break;
                    case ACE:
                        url.append("ace_of_spades.png");
                        break;
                }
                break;
            case DIAMONDS:
                switch (range) {
                    case _2:
                        url.append("2_of_diamonds.png");
                        break;
                    case _3:
                        url.append("3_of_diamonds.png");
                        break;
                    case _4:
                        url.append("4_of_diamonds.png");
                        break;
                    case _5:
                        url.append("5_of_diamonds.png");
                        break;
                    case _6:
                        url.append("6_of_diamonds.png");
                        break;
                    case _7:
                        url.append("7_of_diamonds.png");
                        break;
                    case _8:
                        url.append("8_of_diamonds.png");
                        break;
                    case _9:
                        url.append("9_of_diamonds.png");
                        break;
                    case _10:
                        url.append("10_of_diamonds.png");
                        break;
                    case JACK:
                        url.append("jack_of_diamonds2.png");
                        break;
                    case LADY:
                        url.append("queen_of_diamonds2.png");
                        break;
                    case KING:
                        url.append("king_of_diamonds2.png");
                        break;
                    case ACE:
                        url.append("ace_of_diamonds.png");
                        break;
                }
                break;
            case CLUBS:
                switch (range) {
                    case _2:
                        url.append("2_of_clubs.png");
                        break;
                    case _3:
                        url.append("3_of_clubs.png");
                        break;
                    case _4:
                        url.append("4_of_clubs.png");
                        break;
                    case _5:
                        url.append("5_of_clubs.png");
                        break;
                    case _6:
                        url.append("6_of_clubs.png");
                        break;
                    case _7:
                        url.append("7_of_clubs.png");
                        break;
                    case _8:
                        url.append("8_of_clubs.png");
                        break;
                    case _9:
                        url.append("9_of_clubs.png");
                        break;
                    case _10:
                        url.append("10_of_clubs.png");
                        break;
                    case JACK:
                        url.append("jack_of_clubs2.png");
                        break;
                    case LADY:
                        url.append("queen_of_clubs2.png");
                        break;
                    case KING:
                        url.append("king_of_clubs2.png");
                        break;
                    case ACE:
                        url.append("ace_of_clubs.png");
                        break;
                }
        }

        File frontSideFile = new File(url.toString());
        Image im = new Image(frontSideFile.toURI().toString());               
        return new ImageView(im);
    }

    public ImageView getBackSide() {
        return backSide;
    }

    public void setBackSide(ImageView backSide) {
        this.backSide = backSide;
    }

    public ImageView getFrontSide() {
        return frontSide;
    }

    public void setFrontSide(ImageView frontSide) {
        this.frontSide = frontSide;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }
    
    
}
