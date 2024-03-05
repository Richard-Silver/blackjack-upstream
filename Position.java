package org.simulatedreality.exercises.classesandobjects.blackjack.poc;

public class Position {
  Hand hand;
  
  public Position(Hand hand) {
    this.hand = hand;
  }
  
  public Hand getHand() {
    return this.hand;
  }
  
  public void deal(Card card) {
    this.hand.addCard(card);
  }
}