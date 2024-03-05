package org.simulatedreality.exercises.classesandobjects.blackjack.poc;

public /*abstract, final, ?*/ enum PlayingCard {
  ACE_OF_DIAMONDS,
  TWO_OF_DIAMONDS,
  THREE_OF_DIAMONDS,
  FOUR_OF_DIAMONDS,
  FIVE_OF_DIAMONDS,
  SIX_OF_DIAMONDS,
  SEVEN_OF_DIAMONDS,
  EIGHT_OF_DIAMONDS,
  NINE_OF_DIAMONDS,
  TEN_OF_DIAMONDS,
  JACK_OF_DIAMONDS,
  QUEEN_OF_DIAMONDS,
  KING_OF_DIAMONDS,
  
  ACE_OF_CLUBS,
  TWO_OF_CLUBS,
  THREE_OF_CLUBS,
  FOUR_OF_CLUBS,
  FIVE_OF_CLUBS,
  SIX_OF_CLUBS,
  SEVEN_OF_CLUBS,
  EIGHT_OF_CLUBS,
  NINE_OF_CLUBS,
  TEN_OF_CLUBS,
  JACK_OF_CLUBS,
  QUEEN_OF_CLUBS,
  KING_OF_CLUBS,
  
  ACE_OF_HEARTS,
  TWO_OF_HEARTS,
  THREE_OF_HEARTS,
  FOUR_OF_HEARTS,
  FIVE_OF_HEARTS,
  SIX_OF_HEARTS,
  SEVEN_OF_HEARTS,
  EIGHT_OF_HEARTS,
  NINE_OF_HEARTS,
  TEN_OF_HEARTS,
  JACK_OF_HEARTS,
  QUEEN_OF_HEARTS,
  KING_OF_HEARTS,
  
  ACE_OF_SPADES,
  TWO_OF_SPADES,
  THREE_OF_SPADES,
  FOUR_OF_SPADES,
  FIVE_OF_SPADES,
  SIX_OF_SPADES,
  SEVEN_OF_SPADES,
  EIGHT_OF_SPADES,
  NINE_OF_SPADES,
  TEN_OF_SPADES,
  JACK_OF_SPADES,
  QUEEN_OF_SPADES,
  KING_OF_SPADES;
  
  public String rank;
  public String suit;
  
  
  private PlayingCard() {
    String[] rank_suit = this.toString().split("_OF_");
    
    this.rank = rank_suit[0];
    String rankFirstLetter = this.rank.substring(0, 1);
    this.rank = rankFirstLetter + this.rank.substring(1).toLowerCase();
    
    this.suit = rank_suit[1];
    String suitFirstLetter = this.suit.substring(0, 1);
    this.suit = suitFirstLetter + this.suit.substring(1).toLowerCase();
  }
  
  public String getRank() {
    return this.rank;
  }
  
  public String getSuit() {
    return this.suit;
  }
  
  public static void main(String... args) {
    PlayingCard[] cards = PlayingCard.values();
    for (PlayingCard card : cards) {
      System.out.println(card.rank + " of " + card.suit);
    }
  }
}
//all types, all members, and all constructors should be declared public for the POC. however, the constructor of an enum type must be private or package-private; compiler error generated when declaring it public or protected.