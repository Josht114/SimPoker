/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simpoker;

import simpoker.game.card.Deck;
import simpoker.game.card.Hand;
import simpoker.game.card.Card;
import simpoker.game.card.HandEvaluator;
/**
 *
 * @author Josh
 */
public class Tester
{

    public static void handTester()
    {
                Card c1 = new Card(1, Card.Suit.CLUBS);
                Card c2 = new Card(2, Card.Suit.CLUBS);
                Card c3 = new Card(3, Card.Suit.CLUBS);
                Card c4 = new Card(4, Card.Suit.CLUBS);
                Card c5 = new Card(5, Card.Suit.CLUBS);
                Card c6 = new Card(6, Card.Suit.CLUBS);
                Card c7 = new Card(7, Card.Suit.CLUBS);
                Card c8 = new Card(8, Card.Suit.CLUBS);
                Card c9 = new Card(9, Card.Suit.CLUBS);
                Card c10 = new Card(10, Card.Suit.CLUBS);
                Card c11 = new Card(11, Card.Suit.CLUBS);
                Card c12 = new Card(12, Card.Suit.CLUBS);
                Card c13 = new Card(13, Card.Suit.CLUBS);

                Card s1 = new Card(1, Card.Suit.SPADES);
                Card s2 = new Card(2, Card.Suit.SPADES);
                Card s3 = new Card(3, Card.Suit.SPADES);
                Card s4 = new Card(4, Card.Suit.SPADES);
                Card s5 = new Card(5, Card.Suit.SPADES);
                Card s6 = new Card(6, Card.Suit.SPADES);
                Card s7 = new Card(7, Card.Suit.SPADES);
                Card s8 = new Card(8, Card.Suit.SPADES);
                Card s9 = new Card(9, Card.Suit.SPADES);
                Card s10 = new Card(10, Card.Suit.SPADES);
                Card s11 = new Card(11, Card.Suit.SPADES);
                Card s12 = new Card(12, Card.Suit.SPADES);
                Card s13 = new Card(13, Card.Suit.SPADES);

                Card h1 = new Card(1, Card.Suit.HEARTS);
                Card h2 = new Card(2, Card.Suit.HEARTS);
                Card h3 = new Card(3, Card.Suit.HEARTS);
                Card h4 = new Card(4, Card.Suit.HEARTS);
                Card h5 = new Card(5, Card.Suit.HEARTS);
                Card h6 = new Card(6, Card.Suit.HEARTS);
                Card h7 = new Card(7, Card.Suit.HEARTS);
                Card h8 = new Card(8, Card.Suit.HEARTS);
                Card h9 = new Card(9, Card.Suit.HEARTS);
                Card h10 = new Card(10, Card.Suit.HEARTS);
                Card h11 = new Card(11, Card.Suit.HEARTS);
                Card h12 = new Card(12, Card.Suit.HEARTS);
                Card h13 = new Card(13, Card.Suit.HEARTS);

                Card d1 = new Card(1, Card.Suit.DIAMONDS);
                Card d2 = new Card(2, Card.Suit.DIAMONDS);
                Card d3 = new Card(3, Card.Suit.DIAMONDS);
                Card d4 = new Card(4, Card.Suit.DIAMONDS);
                Card d5 = new Card(5, Card.Suit.DIAMONDS);
                Card d6 = new Card(6, Card.Suit.DIAMONDS);
                Card d7 = new Card(7, Card.Suit.DIAMONDS);
                Card d8 = new Card(8, Card.Suit.DIAMONDS);
                Card d9 = new Card(9, Card.Suit.DIAMONDS);
                Card d10 = new Card(10, Card.Suit.DIAMONDS);
                Card d11 = new Card(11, Card.Suit.DIAMONDS);
                Card d12 = new Card(12, Card.Suit.DIAMONDS);
                Card d13 = new Card(13, Card.Suit.DIAMONDS);


        Hand th1 = new Hand();
        Hand th2 = new Hand();
        Hand th3 = new Hand();
        Hand th4 = new Hand();
        Hand th5 = new Hand();
        Hand th6 = new Hand();
        Hand th7 = new Hand();
        Hand th8 = new Hand();
        Hand th9 = new Hand();
        Hand th10 = new Hand();
        Hand th11 = new Hand();
        Hand th12 = new Hand();
        Hand th13 = new Hand();
        Hand th14 = new Hand();
        Hand th15 = new Hand();
        Hand th16 = new Hand();
        Hand th17 = new Hand();
        Hand th18 = new Hand();
        Hand th19 = new Hand();
        Hand th20 = new Hand();
        Hand th21 = new Hand();
        Hand th22 = new Hand();
        Hand th23 = new Hand();
        Hand th24 = new Hand();
        Hand th25 = new Hand();
        Hand th26 = new Hand();
        Hand th27 = new Hand();
        Hand th28 = new Hand();
        Hand th29 = new Hand();
        Hand th30 = new Hand();
        Hand th31 = new Hand();
        Hand th32 = new Hand();
        Hand th33 = new Hand();
        Hand th34 = new Hand();
        Hand th35 = new Hand();
        Hand th36 = new Hand();
        Hand th37 = new Hand();
        Hand th38 = new Hand();
        Hand th39 = new Hand();
        Hand th40 = new Hand();
        Hand th41 = new Hand();
        Hand th42 = new Hand();
        Hand th43 = new Hand();
        Hand th44 = new Hand();
        Hand th45 = new Hand();
        Hand th46 = new Hand();
        Hand th47 = new Hand();
        Hand th48 = new Hand();
        Hand th49 = new Hand();
        Hand th50 = new Hand();
        Hand th51 = new Hand();
        Hand th52 = new Hand();
        Hand th53 = new Hand();

        //
        //first testing that get highest card wil work and work with any sized hand from 2,5,6 and 7

         th1.setCard1(c2);
         th1.setCard2(h4);
         System.out.println("2 card highest card");
         System.out.println("" + HandEvaluator.getHighestCard(th1));


         th2.setCard1(c2);
         th2.setCard2(h4);
         th2.addCard(d6);
         th2.addCard(s9);
         th2.addCard(c10);
         System.out.println("5 card highest card");
         System.out.println("" + HandEvaluator.getHighestCard(th2));


         th3.setCard1(c2);
         th3.setCard2(h4);
         th3.addCard(d6);
         th3.addCard(s9);
         th3.addCard(c10);
         th3.addCard(d3);
         System.out.println("6 card highest card");
         System.out.println("" + HandEvaluator.getHighestCard(th3));


         th4.setCard1(c2);
         th4.setCard2(h4);
         th4.addCard(d6);
         th4.addCard(s9);
         th4.addCard(c10);
         th4.addCard(d3);
         th4.addCard(d12);
         System.out.println("7 card highest card");
         System.out.println("" + HandEvaluator.getHighestCard(th4));



         //
         //testing that a pair is recognised for all length hands

         th5.setCard1(c2);
         th5.setCard2(h2);
         System.out.println("2 card  pair value");
         System.out.println("" + HandEvaluator.getPairValue(th5));
         


         th6.setCard1(c2);
         th6.setCard2(h2);
         th6.addCard(d6);
         th6.addCard(s9);
         th6.addCard(c10);
         System.out.println("5 card  pair value");
         System.out.println("" + HandEvaluator.getPairValue(th6));


         th7.setCard1(c2);
         th7.setCard2(h2);
         th7.addCard(d6);
         th7.addCard(s9);
         th7.addCard(c10);
         th7.addCard(d3);
         System.out.println("6 card  pair value");
         System.out.println("" + HandEvaluator.getPairValue(th7));


         th8.setCard1(c2);
         th8.setCard2(h2);
         th8.addCard(d6);
         th8.addCard(s6);       //adding in a second pair
         th8.addCard(c10);
         th8.addCard(d3);
         th8.addCard(d12);
         System.out.println("7 card  pair value");
         System.out.println("" + HandEvaluator.getPairValue(th8));
         
         //
         //testing that two pairs for each hand is recognised

         th9.setCard1(c2);
         th9.setCard2(h4);
         System.out.println("2 card two pair value");
         System.out.println("" + HandEvaluator.getTwoPairValue(th9));
//cannot have two pairs with only two cards

         th10.setCard1(c2);
         th10.setCard2(h2);
         th10.addCard(d6);
         th10.addCard(s6);
         th10.addCard(c10);
         System.out.println("5 card two pair value");
         System.out.println("" + HandEvaluator.getTwoPairValue(th10));


         th11.setCard1(c2);
         th11.setCard2(h2);
         th11.addCard(d6);
         th11.addCard(s6);
         th11.addCard(c10);
         th11.addCard(d3);
         System.out.println("6 card two pair value");
         System.out.println("" + HandEvaluator.getTwoPairValue(th11));


         th12.setCard1(c2);
         th12.setCard2(h2);
         th12.addCard(d6);
         th12.addCard(s6);
         th12.addCard(c10);
         th12.addCard(d3);
         th12.addCard(d12);
         System.out.println("7 card two pair value");
         System.out.println("" + HandEvaluator.getTwoPairValue(th12));

         //
         //checks three of a kind works for each length hand

         th13.setCard1(c2);
         th13.setCard2(h2);
         System.out.println("2 card prial value");
         System.out.println("" + HandEvaluator.getPrialValue(th1));
         // cannot get a prial with three cards


         th14.setCard1(c2);
         th14.setCard2(h2);
         th14.addCard(d2);
         th14.addCard(s9);
         th14.addCard(c10);
         System.out.println("5 card prial value");
         System.out.println("" + HandEvaluator.getPrialValue(th14));


         th15.setCard1(c2);
         th15.setCard2(h2);
         th15.addCard(d2);
         th15.addCard(s9);
         th15.addCard(c10);
         th15.addCard(d3);
         System.out.println("6 card Prial value");
         System.out.println("" + HandEvaluator.getPrialValue(th15));


         th16.setCard1(c2);
         th16.setCard2(h2);
         th16.addCard(d2);
         th16.addCard(s9);
         th16.addCard(c10);
         th16.addCard(d3);
         th16.addCard(d12);    // has 3 diamonds now
         System.out.println("7 card prial card value");
         System.out.println("" + HandEvaluator.getPrialValue(th16));

         //
         //checking a straight will be recognised for each length hand


         th17.setCard1(c2);
         th17.setCard2(c3);
         System.out.println("2 card straight value");
         System.out.println("" + HandEvaluator.getStraightValue(th17));
        
         //cannot have 2 card straight


         th18.setCard1(c2);
         th18.setCard2(c3);
         th18.addCard(d4);
         th18.addCard(s5);
         th18.addCard(c6);
         System.out.println("5 card straight value");
         System.out.println("" + HandEvaluator.getStraightValue(th18));


         th19.setCard1(c2);
         th19.setCard2(c3);
         th19.addCard(d4);
         th19.addCard(h5);
         th19.addCard(c6);
         th19.addCard(d3);
         System.out.println("6 card straight value");
         System.out.println("" + HandEvaluator.getStraightValue(th19));


         th20.setCard1(c2);
         th20.setCard2(h3);
         th20.addCard(d4);
         th20.addCard(s5);
         th20.addCard(c6);
         th20.addCard(d11);
         th20.addCard(d12);
         System.out.println("7 card straight value");
         System.out.println("" + HandEvaluator.getStraightValue(th20));

         System.out.println("strt");
         //DO THIS 

         //
         //checking a royal straight will work for all hand lengths

         th21.setCard1(c10);
         th21.setCard2(c11);
         System.out.println("2 card royal straight value");
         System.out.println("" + HandEvaluator.getRoyalStraightValue(th21));
         // cannot have 2 card straight

         th22.setCard1(c10);
         th22.setCard2(c11);
         th22.addCard(d12);
         th22.addCard(s13);
         th22.addCard(c1);
         System.out.println("5 card royal straight value");
         System.out.println("" + HandEvaluator.getRoyalStraightValue(th22));

         th23.setCard1(c10);
         th23.setCard2(c11);
         th23.addCard(d12);
         th23.addCard(s13);
         th23.addCard(c1);
         th23.addCard(c4);
         System.out.println("6 card royal straight value");
         System.out.println("" + HandEvaluator.getRoyalStraightValue(th23));

         th24.setCard1(c10);
         th24.setCard2(c11);
         th24.addCard(d12);
         th24.addCard(s13);
         th24.addCard(c1);
         th24.addCard(c5);
         th24.addCard(c7);
         System.out.println("7 card royal straight value");
         System.out.println("" + HandEvaluator.getRoyalStraightValue(th24));

         //
         //checking a flush is regonised with any hand length

         th25.setCard1(c2);
         th25.setCard2(c4);
         System.out.println("2 flush value");
         System.out.println("" + HandEvaluator.getFlushValue(th25));


         th26.setCard1(c2);
         th26.setCard2(c4);
         th26.addCard(c6);
         th26.addCard(c9);
         th26.addCard(c10);
         System.out.println("5 card flush value");
         System.out.println("" + HandEvaluator.getFlushValue(th26));


         th27.setCard1(c2);
         th27.setCard2(c4);
         th27.addCard(c6);
         th27.addCard(c9);
         th27.addCard(c10);
         th27.addCard(d3);
         System.out.println("6 card flush value");
         System.out.println("" + HandEvaluator.getFlushValue(th27));
         //NOT WORING CHECK ME!!!

         th28.setCard1(c2);
         th28.setCard2(c4);
         th28.addCard(c6);
         th28.addCard(c9);
         th28.addCard(c10);
         th28.addCard(d3);
         th28.addCard(d12);
         System.out.println("7 card flush value");
         System.out.println("" + HandEvaluator.getFlushValue(th28));
         //NOT WORKING CHECK ME

         //
         //check a full house will work for any hand length

         th29.setCard1(c2);
         th29.setCard2(h4);
         System.out.println("2 card full house value");
         System.out.println("" + HandEvaluator.getFullHouseValue(th29));
         //cannot have 2 card full house


         th30.setCard1(c1);
         th30.setCard2(c1);
         th30.addCard(d6);
         th30.addCard(d6);
         th30.addCard(d6);
         System.out.println("5 card full house value");
         System.out.println("" + HandEvaluator.getFullHouseValue(th30));
         //DOESNT WORK CHECK ME!!!!!

         th31.setCard1(c2);
         th31.setCard2(h2);
         th31.addCard(d6);
         th31.addCard(s6);
         th31.addCard(c6);
         th31.addCard(d3);
         System.out.println("6 card full house value");
         System.out.println("" + HandEvaluator.getFullHouseValue(th31));
          //DOESNT WORK CHECK ME!!!!!


         th32.setCard1(c2);
         th32.setCard2(h2);
         th32.addCard(d6);
         th32.addCard(s6);
         th32.addCard(c6);
         th32.addCard(d3);
         th32.addCard(d12);
         System.out.println("7 card full house value");
         System.out.println("" + HandEvaluator.getFullHouseValue(th32));
          //DOESNT WORK CHECK ME!!!!!

         //
         //CHECKS FOUR OF A KIND WORKS WIH ANY LENGTH HAND


         th33.setCard1(c2);
         th33.setCard2(h2);
         System.out.println("2 card four kind value");
         System.out.println("" + HandEvaluator.getFourKindValue(th33));
         // cannot have 2 card four kind

         th34.setCard1(c2);
         th34.setCard2(h2);
         th34.addCard(d2);
         th34.addCard(s2);
         th34.addCard(c10);
         System.out.println("5 card four kind value");
         System.out.println("" + HandEvaluator.getFourKindValue(th34));


         th35.setCard1(c2);
         th35.setCard2(h2);
         th35.addCard(d2);
         th35.addCard(s2);
         th35.addCard(c10);
         th35.addCard(d3);
         System.out.println("6 card four kind value");
         System.out.println("" + HandEvaluator.getFourKindValue(th35));


         th36.setCard1(c2);
         th36.setCard2(h2);
         th36.addCard(d2);
         th36.addCard(s2);
         th36.addCard(c10);
         th36.addCard(d3);
         th36.addCard(d12);
         System.out.println("7 card four kind value");
         System.out.println("" + HandEvaluator.getFourKindValue(th36));

         //
         //checking a straight flush will work for any hand length

         th37.setCard1(c2);
         th37.setCard2(c4);
         System.out.println("2 card straigh flush value");
         System.out.println("" + HandEvaluator.getStraightFlushValue(th37));
         //cannot havw 2 card straight flush


         th38.setCard1(c2);
         th38.setCard2(c3);
         th38.addCard(c4);
         th38.addCard(c5);
         th38.addCard(c6);
         System.out.println("5 card straight flush value");
         System.out.println("" + HandEvaluator.getStraightFlushValue(th38));
         //RETURN IF 1 BEFOR CORRECT VALUE

         th39.setCard1(c2);
         th39.setCard2(c3);
         th39.addCard(c4);
         th39.addCard(c5);
         th39.addCard(c6);
         th39.addCard(d3);
         System.out.println("6 card Straight flush value");
         System.out.println("" + HandEvaluator.getStraightFlushValue(th39));
         //RETURN IF 1 BEFOR CORRECT VALUE

         th40.setCard1(c2);
         th40.setCard2(c4);
         th40.addCard(c3);
         th40.addCard(c5);
         th40.addCard(c6);
         th40.addCard(d3);
         th40.addCard(d12);
         System.out.println("7 card Straight highest card");
         System.out.println("" + HandEvaluator.getStraightFlushValue(th40));
         //RETURN IF 1 BEFOR CORRECT VALUE


         //
         //checking a royal flush will work for all hand lengths FINISH ME

         th41.setCard1(c10);
         th41.setCard2(c11);
         System.out.println("5 card royal flush value");
         System.out.println("" + HandEvaluator.getRoyalFlushValue(th41));
         //CANNOT HAVE 2 CARD ROYAL FLUSH

         th42.setCard1(c10);
         th42.setCard2(c11);
         th42.addCard(c12);
         th42.addCard(c13);
         th42.addCard(c1);
         System.out.println("5 card royal flush value");
         System.out.println("" + HandEvaluator.getRoyalFlushValue(th42));

         th43.setCard1(c10);
         th43.setCard2(c11);
         th43.addCard(c12);
         th43.addCard(c13);
         th43.addCard(c1);
         th43.addCard(d1);
         System.out.println("6 card royal flush value");
         System.out.println("" + HandEvaluator.getRoyalFlushValue(th43));

         th44.setCard1(c10);
         th44.setCard2(c11);
         th44.addCard(c12);
         th44.addCard(c13);
         th44.addCard(c1);
         th44.addCard(s1);
         th44.addCard(d1);
         System.out.println("7 card royal flush value");
         System.out.println("" + HandEvaluator.getRoyalFlushValue(th44));

         //checking the who wins system can recognise a draw between identical hands
         HandEvaluator.printWhoWins(th4, th4);
         
         

         //comparing every hand type with every other to ensure correct one is returned

         //compare every hand t a highest card
        System.out.println("highest card  comparison");
        HandEvaluator.printWhoWins(th2, th6);
        HandEvaluator.printWhoWins(th2, th10);
        HandEvaluator.printWhoWins(th2, th14);
        HandEvaluator.printWhoWins(th2, th18);
        HandEvaluator.printWhoWins(th2, th22);
        HandEvaluator.printWhoWins(th2, th26);
        HandEvaluator.printWhoWins(th2, th30);
        HandEvaluator.printWhoWins(th2, th34);
        HandEvaluator.printWhoWins(th2, th38);
        HandEvaluator.printWhoWins(th2, th42);

        //compairing one pair
        System.out.println("one pair comparison");
        HandEvaluator.printWhoWins(th6, th2);
        HandEvaluator.printWhoWins(th6, th10);
        HandEvaluator.printWhoWins(th6, th14);
        HandEvaluator.printWhoWins(th6, th18);
        HandEvaluator.printWhoWins(th6, th22);
        HandEvaluator.printWhoWins(th6, th26);
        HandEvaluator.printWhoWins(th6, th30);
        HandEvaluator.printWhoWins(th6, th34);
        HandEvaluator.printWhoWins(th6, th38);
        HandEvaluator.printWhoWins(th6, th42);

        //comparing two pair
        System.out.println("two pair comparison");
        HandEvaluator.printWhoWins(th10, th2);
        HandEvaluator.printWhoWins(th10, th6);
        HandEvaluator.printWhoWins(th10, th14);
        HandEvaluator.printWhoWins(th10, th18);
        HandEvaluator.printWhoWins(th10, th22);
        HandEvaluator.printWhoWins(th10, th26);
        HandEvaluator.printWhoWins(th10, th30);
        HandEvaluator.printWhoWins(th10, th34);
        HandEvaluator.printWhoWins(th10, th38);
        HandEvaluator.printWhoWins(th10, th42);

        //comparing three of a kind
        System.out.println("three of a kind comparison");
        HandEvaluator.printWhoWins(th14, th2);
        HandEvaluator.printWhoWins(th14, th6);
        HandEvaluator.printWhoWins(th14, th10);
        HandEvaluator.printWhoWins(th14, th18);
        HandEvaluator.printWhoWins(th14, th22);
        HandEvaluator.printWhoWins(th14, th26);
        HandEvaluator.printWhoWins(th14, th30);
        HandEvaluator.printWhoWins(th14, th34);
        HandEvaluator.printWhoWins(th14, th38);
        HandEvaluator.printWhoWins(th14, th42);

        //comparing straight
        System.out.println("straight comparison");
        HandEvaluator.printWhoWins(th18, th2);
        HandEvaluator.printWhoWins(th18, th6);
        HandEvaluator.printWhoWins(th18, th10);
        HandEvaluator.printWhoWins(th18, th14);
        HandEvaluator.printWhoWins(th18, th22);
        HandEvaluator.printWhoWins(th18, th26);
        HandEvaluator.printWhoWins(th18, th30);
        HandEvaluator.printWhoWins(th18, th34);
        HandEvaluator.printWhoWins(th18, th38);
        HandEvaluator.printWhoWins(th18, th42);

        //comparing royal straight
        System.out.println("royal straight comparison");
        HandEvaluator.printWhoWins(th22, th2);
        HandEvaluator.printWhoWins(th22, th6);
        HandEvaluator.printWhoWins(th22, th10);
        HandEvaluator.printWhoWins(th22, th14);
        HandEvaluator.printWhoWins(th22, th18);
        HandEvaluator.printWhoWins(th22, th26);
        HandEvaluator.printWhoWins(th22, th30);
        HandEvaluator.printWhoWins(th22, th34);
        HandEvaluator.printWhoWins(th22, th38);
        HandEvaluator.printWhoWins(th22, th42);

        //comparing flush
        System.out.println("flush comparison");
        HandEvaluator.printWhoWins(th26, th2);
        HandEvaluator.printWhoWins(th26, th6);
        HandEvaluator.printWhoWins(th26, th10);
        HandEvaluator.printWhoWins(th26, th14);
        HandEvaluator.printWhoWins(th26, th18);
        HandEvaluator.printWhoWins(th26, th22);
        HandEvaluator.printWhoWins(th26, th30);
        HandEvaluator.printWhoWins(th26, th34);
        HandEvaluator.printWhoWins(th26, th38);
        HandEvaluator.printWhoWins(th26, th42);

        //comparing full house
        System.out.println("full house comparison");
        HandEvaluator.printWhoWins(th30, th2);
        HandEvaluator.printWhoWins(th30, th6);
        HandEvaluator.printWhoWins(th30, th10);
        HandEvaluator.printWhoWins(th30, th14);
        HandEvaluator.printWhoWins(th30, th18);
        HandEvaluator.printWhoWins(th30, th22);
        HandEvaluator.printWhoWins(th30, th26);
        HandEvaluator.printWhoWins(th30, th34);
        HandEvaluator.printWhoWins(th30, th38);
        HandEvaluator.printWhoWins(th30, th42);

        //comparing four of a kind
        System.out.println("four of a kind comparison");
        HandEvaluator.printWhoWins(th34, th2);
        HandEvaluator.printWhoWins(th34, th6);
        HandEvaluator.printWhoWins(th34, th10);
        HandEvaluator.printWhoWins(th34, th14);
        HandEvaluator.printWhoWins(th34, th18);
        HandEvaluator.printWhoWins(th34, th22);
        HandEvaluator.printWhoWins(th34, th26);
        HandEvaluator.printWhoWins(th34, th30);
        HandEvaluator.printWhoWins(th34, th38);
        HandEvaluator.printWhoWins(th34, th42);

        //comparing straight flush
        System.out.println("straight fush comparison");
        HandEvaluator.printWhoWins(th38, th2);
        HandEvaluator.printWhoWins(th38, th6);
        HandEvaluator.printWhoWins(th38, th10);
        HandEvaluator.printWhoWins(th38, th14);
        HandEvaluator.printWhoWins(th38, th18);
        HandEvaluator.printWhoWins(th38, th22);
        HandEvaluator.printWhoWins(th38, th26);
        HandEvaluator.printWhoWins(th38, th30);
        HandEvaluator.printWhoWins(th38, th34);
        HandEvaluator.printWhoWins(th38, th42);

        //comparing royal flush
        System.out.println("royal fush comparison");
        HandEvaluator.printWhoWins(th42, th2);
        HandEvaluator.printWhoWins(th42, th6);
        HandEvaluator.printWhoWins(th42, th10);
        HandEvaluator.printWhoWins(th42, th14);
        HandEvaluator.printWhoWins(th42, th18);
        HandEvaluator.printWhoWins(th42, th22);
        HandEvaluator.printWhoWins(th42, th26);
        HandEvaluator.printWhoWins(th42, th30);
        HandEvaluator.printWhoWins(th42, th34);
        HandEvaluator.printWhoWins(th42, th38);




   //      2  6   10   14 18   22   26  30  34 38   42





    }

    public static void WhoWins(Hand hand1, Hand hand2)
    {

        Hand winner = HandEvaluator.compareHands(hand1, hand2);
        if (winner == null) {

            System.out.println("DRAW");
        }
        else {

            System.out.print(winner.toString());
        }
    }
}
