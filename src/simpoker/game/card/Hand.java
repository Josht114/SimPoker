package simpoker.game.card;


/**
 * models a 2 - 7 card hand
 * @author Josh
 */
public class Hand
{

    private Card cards[];
    private int counter;
/**
 * constructor
 */
    public Hand()
    {
        cards = new Card[7];
        counter = 2;
    }

    /**
     * Constructor.
     * @param temp Cards to copy.
     */
    public Hand(Card[] temp)
    {

        this(); // First constructor.

        for (int i = 0; i < temp.length; i++) { // Copies temp.

            cards[i] = temp[i];
        }
    }
/**
 * get the card in the given index
 * @return cad in position index
 */
    public Card getCard(int index)
    {
        if(index < 7 && index > -1)
        {
        return cards[index];
        }

        return null;
    }

/**
 * get the second card in the hand
 * @return card in position 2
 */
    public Card getCard2()
    {
        return cards[1];
    }

    /**
     * sets the first card
     * @param card1 card to set
     */
    public void setCard1(Card card1)
    {
        cards[0] = card1;
    }

    /**
     * sets the second card
     * @param card2 card to set
     */
    public void setCard2(Card card2)
    {
        cards[1] = card2;
    }



    /**
     * Adds a card to the hand.
     * @param c Card to add.
     */
    public void addCard(Card c)
    {
        if (counter >= cards.length) return; // SAFE


         cards[counter] = c;
         counter++;
    }

    /**
     * gives the full hand as an array
     * @return the array of card that make up th hand
     */
    public Card[] getFullHand()
    {
        return cards;
    }


    public int getActiveCardCount()
    {
        int count = 0;
        for (Card c : cards)
        {
            if (c != null)
            {
                count ++;
            }
        }
        return count;
    }

    @Override
    public String toString()
    {

        String output = "Hand:\n";

        boolean hasCards = false;

        for (Card c : getFullHand()) {

            if (c != null) {

                output += c.toString() + "\n";

                hasCards = true;
            }
        }

        if (!hasCards) {

            output += "NO CARDS.";
        }

        return output;
    }

}