package simpoker.game.card;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * evaluates the best rank of a hand
 * private constructor and static methods
 * @author Josh
 */
public class HandEvaluator
{

/**
 * private constructor so hand evaluator cannot be made
 */
    private HandEvaluator()
    {

    }
/**
 * creates a enum for all possible hands in poker
 */
    private static enum hRank
    {
        ROYALFLUSH, STRAIGHTFLUSH, FOURKIND, FULLHOUSE, FLUSH, STRAIGHT, PRIAL, TWOPAIR, PAIR, HIGHCARD;
    }


     public static void printWhoWins(Hand hand1, Hand hand2)
    {

        Hand winner = HandEvaluator.compareHands(hand1, hand2);
        if (winner == null) {

            System.out.println("DRAW");
        }
        else {

            System.out.print(winner.toString());
        }
    }





    /**
     * returns the best hand out of two given hands
     * @param h1 first hand to check
     * @param h2 second hand to check
     * @return the best hand
     */
    public static Hand compareHands(Hand h1, Hand h2)
    {
        if (getHandRank(h1) > getHandRank(h2) )
        {
           return h1;
        }
        else if (getHandRank(h2) > getHandRank(h1))
        {
            return h2;
        }
        else
        {
            int order = getHandRank(h1);

            switch (order)
            {
                case 11 :
                   if(getRoyalFlushValue(h1) > getRoyalFlushValue(h2))
                   {
                       return h1;
                   }
                   else if (getRoyalFlushValue(h2) > getRoyalFlushValue(h1))
                   {
                       return h2;
                   }
                    else if (getRoyalFlushValue(h2) == getRoyalFlushValue(h1))
                   {
                       return null;
                   }

                    case 10 :
                   if(getStraightFlushValue(h1) > getStraightFlushValue(h2))
                   {
                       return h1;
                   }
                   else if (getStraightFlushValue(h2) > getStraightFlushValue(h1))
                   {
                       return h2;
                   }
                    else if (getStraightFlushValue(h2) == getStraightFlushValue(h1))
                   {
                       return null;
                   }
                    case 9:
                   if(getFourKindValue(h1) > getFourKindValue(h2))
                   {
                       return h1;
                   }
                   else if (getFourKindValue(h2) > getFourKindValue(h1))
                   {
                       return h2;
                   }
                    else if (getFourKindValue(h2) == getFourKindValue(h1))
                   {
                       return null;
                   }

                    case 8:
                   if(getFullHouseValue(h1) > getFullHouseValue(h2))
                   {
                       return h1;
                   }
                   else if (getFullHouseValue(h2) > getFullHouseValue(h1))
                   {
                       return h2;
                   }
                    else if (getFullHouseValue(h2) == getFullHouseValue(h1))
                   {
                       return null;
                   }

                    case 7:
                   if(getFlushValue(h1) > getFlushValue(h2))
                   {
                       return h1;
                   }
                   else if (getFlushValue(h2) > getFlushValue(h1))
                   {
                       return h2;
                   }
                    else if (getFlushValue(h2) == getFlushValue(h1))
                   {
                       return null;
                   }

                   case 6:
                   if(getRoyalStraightValue(h1) > getRoyalStraightValue(h2))
                   {
                       return h1;
                   }
                   else if (getRoyalStraightValue(h2) > getRoyalStraightValue(h1))
                   {
                       return h2;
                   }
                    else if (getRoyalStraightValue(h2) == getRoyalStraightValue(h1))
                   {
                       return null;
                   }

                   case 5:
                   if(getStraightValue(h1) > getStraightValue(h2))
                   {
                       return h1;
                   }
                   else if (getStraightValue(h2) > getStraightValue(h1))
                   {
                       return h2;
                   }
                    else if (getStraightValue(h2) == getStraightValue(h1))
                   {
                       return null;
                   }

                   case 4:
                   if(getPrialValue(h1) > getPrialValue(h2))
                   {
                       return h1;
                   }
                   else if (getPrialValue(h2) > getPrialValue(h1))
                   {
                       return h2;
                   }
                    else if (getPrialValue(h2) == getPrialValue(h1))
                   {
                       return null;
                   }

                   case 3:
                   if(getTwoPairValue(h1) > getTwoPairValue(h2))
                   {
                       return h1;
                   }
                   else if (getTwoPairValue(h2) > getTwoPairValue(h1))
                   {
                       return h2;
                   }
                    else if (getTwoPairValue(h2) == getTwoPairValue(h1))
                   {
                       return null;
                   }

                   case 2:
                   if(getPairValue(h1) > getPairValue(h2))
                   {
                       return h1;
                   }
                   else if (getPairValue(h2) > getPairValue(h1))
                   {
                       return h2;
                   }
                    else if (getPairValue(h2) == getPairValue(h1))
                   {
                       return null;
                   }

                   case 1:
                   if(getHighestCard(h1) > getHighestCard(h2))
                   {
                       return h1;
                   }
                   else if (getHighestCard(h2) > getHighestCard(h1))
                   {
                       return h2;
                   }
                    else if (getHighestCard(h2) == getHighestCard(h1))
                   {
                       return null;
                   }

                default : return null;
            }
        }
    }

    /**
     * hand ranks are ordered from 11-1, the value of a hank will be returned as an int royal flush is 11 ect
     * @param givHand hand to check
     * @return int int value of each hand
     */
    public static int getHandRank(Hand givHand)
    {
        //int order;
        //switch (order)
        //{
        //case  getRoyalFlush(givHand) == true: order ;

      //  }
        if (isRoyalFlush(givHand) == true)
        {
            return 11;
        }
        else if (isStraightFlush(givHand) == true)
        {
            return 10;
        }
         else if (isFourKind(givHand) == true)
        {
            return 9;
        }
         else if (isFullHouse(givHand) == true)
        {
            return 8;
        }
         else if (isFlush(givHand) == true)
        {
            return 7;
        }
         else if (isRoyalStraight(givHand) == true)
        {
            return 6;
        }
         else if (isStraight(givHand) == true)
        {
            return 5;
        }
         else if (isPrial(givHand) == true)
        {
            return 4;
        }
         else if (isTwoPair(givHand) == true)
        {
            return 3;
        }
         else if (isPair(givHand) == true)
        {
            return 2;
        }
         else   // just highest card
        {
            return 1;
        }

    }



    /**
     * Gets value of the pair.
     * @param givHand the hand to check
     * @return  pair value.
     */
    public static int getPairValue(Hand givHand)
     {
        ArrayList<Card> cards = new ArrayList<Card>();

        for (Card c : givHand.getFullHand())
        {
            if (c == null)
            { // LAST CARD SO BREAK OUT OF LOOP
                break;
            }

            if (cards.contains(c))
            {
               // int realValue = c.getRank();
                //if (realValue == 1) {

                  //  realValue = 14; // ACE.
                //}
               // return realValue;

                return c.getTrueValue();
            }
            else 
            {
                cards.add(c);
            }
        }

        return 0;
     }

    /**
     * checks if a hand contains a pair
     * @param givHand the hand to check
     * @return  true if hand contains a pair
     */
    public static boolean isPair(Hand givHand)
    {
        return getPairValue(givHand) > 0;
    }


    /**
     * finds the value of a prial in a hand
     * @param givHand the hand to be searched
     * @return gives rank of prial
     */
    public static int getPrialValue(Hand givHand)
    {
        ArrayList<Card> cards = new ArrayList<Card>();

        for (Card c : givHand.getFullHand())
        {

            if (c == null)  // LAST CARD SO BREAK OUT OF LOOP
            {
                break;
            }

            // to ARRAY = ArrayList to Array[]
            // e.g. cards to Card[]
            if (countRank(c.getRank(), cards.toArray(new Card[cards.size()])) == 2) // 2 + current card = 3 = PRIAL
            {
                // int realValue = c.getRank();
                //if (realValue == 1)
                //{

                  //  realValue = 14; // ACE.

                //}
                //return realValue;
                return c.getTrueValue();
            }
            else
            {
                cards.add(c);
            }
        }

        return 0;

    }

    /**
     * returns true if the hand is a prial by using getprial value to check and return a number above 0
     * @param givHand the hand to check
     * @return givrs true if han is prial
     */
    public static boolean isPrial(Hand givHand)
    {
        return getPrialValue(givHand) > 0; // if value above 0 its a prial
    }

    /**
     * finds the value of the four of a kind
     * @param givHand hand to check
     * @return value of four of a kind
     */
    public static int getFourKindValue(Hand givHand)
    {
        ArrayList<Card> cards = new ArrayList<Card>();

        for (Card c : givHand.getFullHand())
        {

            if (c == null)  // LAST CARD SO BREAK OUT OF LOOP
            {
                break;
            }

            if (countRank(c.getRank(), cards.toArray(new Card[cards.size()])) == 3) // 2 + current card = 3 = PRIAL
            {
           //      int realValue = c.getRank();
         //       if (realValue == 1)
           //     {
             //       realValue = 14; // ACE.
              //  }
                //return realValue;
                return c.getTrueValue();
            }
            else
            {
                cards.add(c);
            }
        }

        return 0;

       }
    /**
     * gives trues if four of a kind
     * @param givHand hand to check
     * @return true if four of a kind
     */
     public static boolean isFourKind(Hand givHand)
    {
        return getFourKindValue(givHand) > 0; // if value above 0 its a prial
    }

     /**
      * gets the value of the highest pair when two pairs are present
      * @param givHand hand to check
      * @return value of highest pair
      */
     public static int getTwoPairValue(Hand givHand)
     {
        ArrayList<Card> cards = new ArrayList<Card>();

        Card firstPair = null;

        for (Card c : givHand.getFullHand())
        {
            if (c == null)
            { // LAST CARD SO BREAK OUT OF LOOP
                break;
            }

            if (cards.contains(c)) // NEW PAIR!
            {

                if (firstPair == null)   // IF WE HAVE A FIRST PAIR YET!
                {

                    firstPair = c; // SET FIRST PAIR.
                }
                else {

                    if (!firstPair.equals(c))   // NOT PRIAL...
                     {

                        int realFirst = firstPair.getRank();
                        if (realFirst == 1) {

                            realFirst = 14; // ACE
                        }
                        int realSecond = c.getRank();
                        if (realSecond == 1) {

                            realSecond = 14; // ACE
                        }

                        if (realFirst > realSecond)  // FIND HIGHEST VALUE..
                        {

                            return realFirst;
                        }
                        else
                        {
                            return realSecond;
                        }
                     }
                   }
            }

            cards.add(c);
        }

        return 0;
     }

    /**
     * gives trues if two pair
     * @param givHand hand to check
     * @return true if two pair
     */
     public static boolean isTwoPair(Hand givHand)
    {
        return getTwoPairValue(givHand) > 0; // if value above 0 its a prial
    }

/**
 * finds the highest card for a given hand
 * @param givHand hand to be checked
 * @return give rank value of highest card
 */
     public static int getHighestCard(Hand givHand)
     {
         int value = 0;
         for (Card c : givHand.getFullHand())
         {
             if (c == null)
             {
                 break;
             }
             if (c.getRank() > value)
             {
                 value = c.getRank();
             }


         }
         if (value == 1 )
         {
             value = 14; // if ace
         }
         return value;
     }

   //  public static int isHighestCard(Hand)

     /**
      * finds if a hand contains both a pair and a prial(a full house)
      * @param givHand hand to be checked
      * @return the rank of the highest card in the prial of the full house
      */
     public static int getFullHouseValue(Hand givHand)
     {

         int value = getPrialValue(givHand);

         if(value > 0 )
         {
           ArrayList<Card> newCards = new ArrayList<Card>();

           for (Card c : givHand.getFullHand())
           {
               if(c != null && c.getTrueValue() != value)
               {
                   newCards.add(c);
               }

           }

           if (isPair(new Hand(newCards.toArray(new Card [newCards.size()]))))
           {

               return value;
           }

         }

         

        return 0;
     }

     /**
      * gives true if full house
      * @param givHand hand to check
      * @return true if full house false is not
      */
     public static boolean isFullHouse(Hand givHand)
     {
         return getFullHouseValue(givHand) >0;
     }

     /**
      * checks if five cards have the same suit 
      * @param givHand hand to check 
      * @return returns highest card in the flush
      */
     public static int getFlushValue(Hand givHand)
     {

         int hearts = 0, spades = 0, diamonds = 0, clubs = 0;

         for (Card c : givHand.getFullHand())
         {

             if (c == null)
             {

                 break;
             }

             switch (c.getSuit())
             {

                 case HEARTS: hearts++; break;
                 case SPADES: spades++; break;
                 case DIAMONDS: diamonds++; break;
                 case CLUBS: clubs++; break;
             }

             if (hearts == 5 || spades == 5 || diamonds == 5 || clubs == 5)
             {

                 Card[] valueCards; // JUST THE FLUSH
                 if (hearts == 5)
                 {

                     valueCards = getCardsOfSuit(givHand.getFullHand(), Card.Suit.HEARTS);
                 }
                 else if (spades == 5)
                 {

                     valueCards = getCardsOfSuit(givHand.getFullHand(), Card.Suit.SPADES);
                 }
                 else if (diamonds == 5)
                 {

                     valueCards = getCardsOfSuit(givHand.getFullHand(), Card.Suit.DIAMONDS);
                 }
                 else
                 {

                     valueCards = getCardsOfSuit(givHand.getFullHand(), Card.Suit.CLUBS);
                 }

                 valueCards = orderCards(valueCards); // Order our cards.

                 if (countRank(1, valueCards) >= 1)
                 { // ACE..

                     return 14;
                 }
                 else
                 {

                     return valueCards[valueCards.length - 1].getRank(); // HIGHEST CARD
                 }
             }
         }

         return 0;
     }

     /**
      * gives true if flush is present
      * @param givHand hand to check
      * @return true if flush
      */
     public static boolean isFlush(Hand givHand)
     {
         return getFlushValue(givHand) > 0;
     }

     /**
      * gives back all the cards from a given array of cards who have a given suit
      * @param cards an array of cards
      * @param s a possible suit
      * @return an array of cards that have the given suit
      */


     ///////////////////////////////////////////






     //if one befor then ignore when adding!!!!
     // ace is always low

     /**
      * returns the highet card in a straight if a straight is present
      * @param givHand hand to check
      * @return rank of highest card is straight
      */
     public static int getStraightValue(Hand givHand)
     {

         ArrayList<Card> checkedCards = new ArrayList<Card>(); // array list to manipulate

            Card sortedCards1[] = orderCards(givHand.getFullHand()); // array to order


    //for every card in hand when ordered if card is of same rank as next card do not put in array
           for(int x=0; x < sortedCards1.length; x++)
           {
               if(sortedCards1[x] == null)
               {
                  // System.out.println("broke cuz of null");
                   break;
               }
               if (x == sortedCards1.length - 1) {
                   
                   checkedCards.add(sortedCards1[x]);
               }
               else if (sortedCards1[x].getRank() != sortedCards1[x + 1].getRank())
               {
                   checkedCards.add(sortedCards1[x]);
               }
           }

            if(checkedCards.size() < 5)
            {
                return 0; 
            }
          // takes array wiith no repeated ranks and creates an array to use
          Card sortedCards[] = checkedCards.toArray(new Card[checkedCards.size()]);   //orderCards(givHand.getFullHand());


          
        if(   sortedCards.length == 5
           && sortedCards[1].getRank() == sortedCards[0].getRank() +1
           && sortedCards[2].getRank() == sortedCards[1].getRank() +1
           && sortedCards[3].getRank() == sortedCards[2].getRank() +1
           && sortedCards[4].getRank() == sortedCards[3].getRank() +1
          )
       {
            
          return sortedCards[4].getRank();
       }

       else if ( sortedCards.length == 6
              && sortedCards[2].getRank() == sortedCards[1].getRank() +1
              && sortedCards[3].getRank() == sortedCards[2].getRank() +1
              && sortedCards[4].getRank() == sortedCards[3].getRank() +1
              && sortedCards[5].getRank() == sortedCards[4].getRank() +1
          )
       {
          
          return sortedCards[5].getRank();
       }

       else if ( 
                 sortedCards.length == 7
              && sortedCards[3].getRank() == sortedCards[2].getRank() +1
              && sortedCards[4].getRank() == sortedCards[3].getRank() +1
              && sortedCards[5].getRank() == sortedCards[4].getRank() +1
              && sortedCards[6].getRank() == sortedCards[5].getRank() +1
               )

       {
           
          return sortedCards[6].getRank();
       }
           // System.out.println("didntwork");
           return 0;
       
     }

/**
 * gives true if hand contains straight
 * @param givHand hand to check
 * @return true if straight false if not
 */
     public static boolean isStraight(Hand givHand)
     {
         if (getStraightValue(givHand) >0 )
         {
             return true;
         }
         return false;
     }

     /**
      * assumes aces are high and checks for a royal straight (10 j q k ace)
      * @param givHand hand to check
      * @return returns 14 if royal straight is present else 0
      */
     public static int getRoyalStraightValue(Hand givHand)
     {
         ArrayList<Card> checkedCards = new ArrayList<Card>(); // array list to manipulate

            Card sortedCards1[] = orderCards(givHand.getFullHand()); // array to order


    //for every card in hand when ordered if card is of same rank as next card do not put in array
           for(int x=0; x < sortedCards1.length; x++)
           {
               if(sortedCards1[x] == null)
               {
                  // System.out.println("broke cuz of null");
                   break;
               }
               if (x == sortedCards1.length - 1) {

                   checkedCards.add(sortedCards1[x]);
               }
               else if (sortedCards1[x].getRank() != sortedCards1[x + 1].getRank())
               {
                   checkedCards.add(sortedCards1[x]);
               }
           }

            if(checkedCards.size() < 5)
            {
                return 0;
            }
          // takes array wiith no repeated ranks and creates an array to use
          Card sortedCards[] = checkedCards.toArray(new Card[checkedCards.size()]);

         if(
              sortedCards.length == 5
           && sortedCards[0].getRank() == 1
           && sortedCards[1].getRank() == 10
           && sortedCards[2].getRank() == 11
           && sortedCards[3].getRank() == 12
           && sortedCards[4].getRank() == 13
           )
         {
             return 14;
         }
           else if (
                  sortedCards.length == 6
               && sortedCards[0].getRank() == 1
               && sortedCards[2].getRank() == 10
               && sortedCards[3].getRank() == 11
               && sortedCards[4].getRank() == 12
               && sortedCards[5].getRank() == 13
                   )
         {
             return 14;
         }
         else if  (
                  sortedCards.length == 7
               && sortedCards[0].getRank() == 1
               && sortedCards[3].getRank() == 10
               && sortedCards[4].getRank() == 11
               && sortedCards[5].getRank() == 12
               && sortedCards[6].getRank() == 13
                  )
         {
            return 14;
         }
         
         
         return 0;
     }

     /**
      * returns true if royal straight is present else false
      * @param givHand
      * @return true if royal straigh else false
      */
     public static boolean isRoyalStraight(Hand givHand)
     {
         if (getRoyalStraightValue(givHand) > 0 )
         {
             return true;
         }
         return false;
     }
     

     /**
      * if a straight flush is present returns the value of the highest card in the flush
      * @param givHand
      * @return rank of highest card in straight
      */
     public static int getStraightFlushValue(Hand givHand)
     {
         int value = 0;

         // could get all cards of suit then find out if they make a flush
         value = getFlushValue(givHand);
         if (value > 0) { // Its a flush (rupert).

             Card checkSuit = orderCards(givHand.getFullHand())[3]; // THIRD ONE IS ALWAYS A CARD AND OUR SUIT.
             Card[] flush = getCardsOfSuit(givHand.getFullHand(), checkSuit.getSuit()); // Get our flush.

             return getStraightValue(new Hand(flush));
         }

         return 0;
     }

     public static boolean isStraightFlush(Hand givHand)
     {
         if (getStraightFlushValue(givHand) > 0)
         {
             return true;
         }
         return false;
     }

     public static int getRoyalFlushValue(Hand givHand)
     {
         int value = 0;

         // could get all cards of suit then find out if they make a flush
         value = getFlushValue(givHand);
         if (value > 0) { // Its a flush (rupert).

             Card checkSuit = orderCards(givHand.getFullHand())[3]; // THIRD ONE IS ALWAYS A CARD AND OUR SUIT.
             Card[] flush = getCardsOfSuit(givHand.getFullHand(), checkSuit.getSuit()); // Get our flush.

             if (getRoyalStraightValue(new Hand(flush)) == 14) {

                 return 14;
             }
         }

         return 0;
     }

      public static boolean isRoyalFlush(Hand givHand)
     {
         if (getRoyalFlushValue(givHand) > 0)
         {
             return true;
         }
         return false;
     }
     /**
      * get all the cards of a given suit from a given array of cards
      * @param cards arrays of card to look through
      * @param s the suit to check for
      * @return an array of all the gards of the given suit
      */
     public static Card[] getCardsOfSuit(Card[] cards, Card.Suit s)
     {

         ArrayList<Card> suitCards = new ArrayList<Card>();

         for (Card c : cards)
         {

             if (c == null)
             {

                 break;
             }
             else if (c.getSuit() == s)
             {

                 suitCards.add(c);
             }
         }

         return suitCards.toArray(new Card[suitCards.size()]);
     }

     /**
      * orders a given array of cards
      * @param cards an array of card to be ordered
      * @return an array of cards in order
      */
     public static Card[] orderCards(Card[] cards)
     {

         int nullCount = 0;

         for (Card c : cards)
         {
             if (c == null)
             {
                 nullCount++;
             }
         }

         Card[] sortedCards = new Card[cards.length - nullCount];
         for (int i = 0; i < sortedCards.length; i++) {

             sortedCards[i] = cards[i];
         }

         Arrays.sort(sortedCards);

         return sortedCards;
     }

    /**
     * counts how many cards of a specific rank are in an array of cards
     * @param rank the rank which you are counting the instances of
     * @param cards the array you are looking through
     * @return gives the rank of the prial
     */
    private static int countRank(int rank, Card[] cards)
    {

        int count = 0;

        for (Card c : cards)
        {

            if (c.getRank() == rank)
            {
            count++;
            }
        }

        return count;
    }

}

