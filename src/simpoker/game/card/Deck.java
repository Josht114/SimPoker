package simpoker.game.card;

import java.util.Random;

/**
 * creates a standard shuffeled 52 card deck of playing cards
 * @author Josh
 */
public class Deck
{
    private Card[] cards;
    private int counter;

    /**
     * constructor that creates a sheffeled deck
     */
    public Deck()
    {
         shuffle();
    }

    /**
     * creates an array of the 52 standard cards and randomly places them in the deck
     */
    public void shuffle()
    {
        cards = new Card[52];
        counter = 0;

        for (Card.Suit s : Card.Suit.values()) // all suits (values can be called on enums)
        {
            for (int i = 1; i < 14; i++) // all cards in suit
            {
                placeInDeck(new Card(i, s)); // put in the deck
            }
        }
    }
/**
 * randomly places the cards into the deck checks to ensure cards are not placed in the same index
 * @param c card in the deck
 */
    private void placeInDeck(Card c)
    {

        Random rand = new Random();

        int index = rand.nextInt(52); // random index
        while (cards[index] != null) // check no card is already there
        {
            index = rand.nextInt(52);
        }

        cards[index] = c; // put card
    }

    /**
     *get the nect card from the deck and incriments the index (auto shuffle)
     * @return the next card from the deck
     */
    public Card getNextCard()
    {
        if (counter == 52) // check in array
        {
            shuffle();
        }

        Card topCard = cards[counter]; // get the next card

        counter++; // move counter along

        return topCard;
    }
}
