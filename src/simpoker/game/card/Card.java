package simpoker.game.card;

/**
 * models standard 52 playing cards
 * @author Josh Trevenna (SU NU)
 */
public class Card implements Comparable
{

/**
 * creates an enum of all possible suits
 */
    public enum Suit
    {

        SPADES, HEARTS, DIAMONDS, CLUBS;
    }

    private int rank;
    private Suit suit;

    /**
     * card constructor, need rank and suit
     * @param rank cards number
     * @param suit cards suit
     */
    public Card(int rank, Suit suit)
    {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * finds a cards rank
     * @return gives rank
     */
    public int getRank()
    {
        return rank;
    }
/**
 * gives the rank in text from
 * @return string of rank
 */
    public String getRankText()
    {

        if (rank == 1)
        {

            return "ACE";
        }
        else if (rank < 11)
        {

            return ("" + rank);
        }
        else {

            switch (rank)
            {

                case 11:
                    return "JACK";
                case 12:
                    return "QUEEN";
                default:
                    return "KING";
            }
        }
    }

    /**
     * gets suit of a card
     * @return gives suit
     */
    public Suit getSuit()
    {
        return suit;
    }

    /**
     * overrides tostring function for display purposes
     * @return string representation of object
     */
    @Override
    public String toString()
    {

        return getRankText() + " of " + suit.toString();

    }

    /**
     * COMMENT ME TOO.s
     * @return
     */
    public int getTrueValue()
    {

        return getTrueValue(this);
    }

    /**
     * COMMENT ME FUCK..
     * @param c
     * @return
     */
    public static int getTrueValue(Card c) {

        if (c.getRank() == 1) {

            return 14;
        }
        else {

            return c.getRank();
        }
    }

    /**
     * compares two card and tell which card is higher
     * @param obj1 first card
     * @param obj2 second card
     * @return 1 if first card is bigger, -1 if first card is smaller and 0 if cards are equal
     */
    public int compareTo(Object obj) {

        if (!(obj instanceof Card)) return 1; // NOT CARDS..

        Card card = (Card)obj;

        if (getRank() > card.getRank()) {

            return 1; // GREATER THAN.
        }
        else if (getRank() < card.getRank()) {

            return -1; // LESS THAN.
        }
        else {

            return 0; // EQUAL.
        }
    }

    /**
     * overides equals function to only check and compare rank if object and class is correct
     * @param obj
     * @return gives true if card ranks are same else false
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Card other = (Card) obj;
        if (this.rank != other.getRank())
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.rank;
        hash = 79 * hash + this.suit.hashCode();
        return hash;
    }
}
