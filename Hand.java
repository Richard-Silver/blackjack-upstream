package org.simulatedreality.exercises.classesandobjects.blackjack.poc;

import java.util.Arrays;

public class Hand {
  public Card[] cards = new Card[0];
  public byte handValue = 0;//empty hand
  
  //implicit empty argument constructor
  
  public Card[] getCards() {
    return this.cards;
  }
  
  public byte getHandValue() {
    return this.handValue;
  }
  
  public void addCard(Card card) {
    this.cards = Arrays.copyOf(this.cards, this.cards.length + 1);
    this.cards[this.cards.length - 1] = card;
    this.setHandValue(Hand.determineHandValue(this));
  }
  
  public Card[] getHand() {
    return this.cards;
  }
  
  public void setHandValue(byte value) {
    switch (this.cards.length) {
      case 2:
        if (value == 21) {
          this.handValue = 100; //blackjack
        } else {
          this.handValue = value;//cannot bust with only the initial hand of two cards
        }
        break;
      default:
        if (value > 21) {
          this.handValue = -100; //bust
        } else {
          this.handValue = value;
        }
        break;
    }
  }
  
  //returns 0 or greater
  public static byte determineHandValue(Hand hand) {
    byte value = 0;
    boolean foundAce = false;
    for(Card card : hand.getCards()) {
      switch (card.getRank()) {
        case "Ace":
          if (!foundAce) {
            value += 11;
            foundAce = !foundAce;
          } else {
            value += 1;
          }
          break;
        case "Two":
          value += 2;
          break;
        case "Three":
          value += 3;
          break;
        case "Four":
          value += 4;
          break;
        case "Five":
          value += 5;
          break;
        case "Six":
          value += 6;
          break;
        case "Seven":
          value += 7;
          break;
        case "Eight":
          value += 8;
          break;
        case "Nine":
          value += 9;
          break;
        case "Ten": case "Jack":
        case "Queen": case "King":
          value += 10;
          break;
      }
    }
    if (value > 21 && foundAce) {
      value -= 10;
    }
    return value;
  }
  
}
//although tempted to check if a duplicate (reference equality) is being added and reject it if it is, it could convolute the POC into something more than that.
//although tempted to check for nulls do afterwards after program can run at least one round