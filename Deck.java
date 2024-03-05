package org.simulatedreality.exercises.classesandobjects.blackjack.poc;

import java.util.Arrays;

public class Deck {
  public Card[] deck;
  
  public Deck() {
    PlayingCard[] playingCards = PlayingCard.values();
    this.deck = new Card[playingCards.length];
    for(int i = 0; i < playingCards.length; i++) {
      this.deck[i] = new Card(playingCards[i]);
    }
  }
  
  public Card[] Cards() {
    return this.deck;
  }
  
  public Card deal() {
    Card topCard = this.deck[this.deck.length - 1];
    this.deck = Arrays.copyOf(this.deck, this.deck.length - 1);
    return topCard;
  }
  
  public void nothing() {}
}

Some code that randomizes the cards dealt. Hooray!








/*avoid even this simple code. its still too complex
public class Deck {
  public enum NumberOfDecks {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8);
    public int number;
    private NumberOfDecks(int number) {
      this.number = number;
    }
  }
  
  public Deck(NumberOfDecks number) {
    for(byte i = 1; byte <= numOfDecks; byte++) {
      for(PlayingCard card : PlayingCard.values()) {
        
      }
    }
  }
}
*/