package org.simulatedreality.exercises.classesandobjects.blackjack.poc;

public class Table {
  Dealer dealer;
  Deck deck;
  Position position;
  
  public Table(Dealer dealer, Deck deck, Position position) {
    this.dealer = dealer;
    this.deck = deck;
    this.position = position;
  }
  
  public Dealer getDealer() {
    return this.dealer;
  }
  
  public Deck getDeck() {
    return this.deck;
  }
  
  public Position getPosition() {
    return this.position;
  }
  
  public void initialDeal() {
    for (int i = 1; i <= 2; i++) {
      this.deal(this.position);
      this.deal(this.dealer);
    }
  }
  
  public void deal(Position position) {
    position.deal(deck.deal());
  }
  
}

/*code to prompt user to enter an appropriate amount for the initial bet*/