package simpoker.game.player;

import simpoker.game.card.Card;
import simpoker.game.card.Hand;

/**
 *
 * @author Josh
 */
public abstract class Player
{
private int money;
private int raiseAmount;
private Hand myHand;
protected Action temAc;


    public Player()
    {
        money = 0;
        myHand = new Hand();

    }

    
    public enum Action
    {
        RAISE, CALL, FOLD, BET, CHECK, MATCHBET;
    }

    public  Action getAction()
    {
        return temAc;
    }
    
    public void setAction(Action ac)
    {
        temAc = ac;
    }

    public void SetHand(Card c1,Card c2)
    {
        myHand.setCard1(c1);
        myHand.setCard2(c2);
    }

    public void givCard(Card c)
    {
        myHand.addCard(c);
    }


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Hand getMyHand() {
        return myHand;
    }

    public void setMyHand(Hand myHand) {
        this.myHand = myHand;
    }

    public int getRaise() {
        return raiseAmount;
    }

    public void setRaise(int raiseAmount) {
        this.raiseAmount = raiseAmount;
    }

    public abstract String winStatment();

    public void clearHand()
    {
        myHand = new Hand();
    }


    public Card getCard(int i)
    {
        return myHand.getCard(i);
    }



}


