package org.simulatedreality.exercises.classesandobjects.blackjack.poc;

public class Card {
  public String rank;
  public String suit;
  
  public Card(PlayingCard card) {
    this.rank = card.getRank();
    this.suit = card.getSuit();
  }
  
  public String getRank() {
    return this.rank;
  }
  
  public String getSuit() {
    return this.suit;
  }
  
  public String toString() {
    return this.rank + " of " + this.suit;
  }
}

//wrapper class to make cards unique
//even though all members will have public access, they should only be accessed with get methods.
//all member variables should be exposed through get methods. 