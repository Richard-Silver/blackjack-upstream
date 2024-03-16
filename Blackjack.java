package org.simulatedreality.exercises.classesandobjects.blackjack.poc;

import java.io.Console;

public class Blackjack {
  System.out.println("hello world");
  public static void main(String... args) {
    Console console = System.console();
    if (console == null) {
      System.err.println("console not available");
      System.exit(1);
    }
    boolean stand = false;
    Deck deck = new Deck();
    Dealer dealer = new Dealer(new Hand());
    Position position = new Position(new Hand());
    Table table = new Table(dealer, deck, position);
    System.out.println("Blackjack");
    System.out.println("The initial deal");
    table.initialDeal();
    Card[] dealerCards = table.getDealer().getHand().getCards();
    Card[] positionCards = table.getPosition().getHand().getCards();
    System.out.println("Dealer has a " + dealerCards[0].toString() + " and a face-down card");
    System.out.println("You have been dealt a " + positionCards[0].toString() + " and a " + positionCards[1].toString());
    while (table.getPosition().getHand().getHandValue() >= 0 && !stand) {
      System.out.println("HIT");
      System.out.println("STAND");
      String decision = console.readLine();
      switch (decision) {
        case "HIT":
          table.deal(table.getPosition());
          break;
        case "STAND":
          stand = true;
          continue;
        default:
          System.out.println("Invalid input. Try again.");
          continue;
      }
      dealerCards = table.getDealer().getHand().getCards();
      positionCards = table.getPosition().getHand().getCards();
      System.out.println("Dealer has a " + dealerCards[0].toString() + " and a face-down card");
      System.out.print("Your hand consists of");
      for (Card card : positionCards) {
        System.out.print(" " + card.toString());
      }
      System.out.println();
    }
    if (table.getPosition().getHand().getHandValue() == -100) {
      System.out.println("YOU BUSTED!");
      System.out.println("HOUSE WINS!");
      System.exit(0);
    }
    dealerCards = table.getDealer().getHand().getCards();
    positionCards = table.getPosition().getHand().getCards();
    System.out.println("Dealer has a " + dealerCards[0].toString() + " and a " + dealerCards[1]);
    System.out.print("Your hand consists of");
    for (Card card : positionCards) {
      System.out.print(" " + card.toString());
    }
    System.out.println();
    while (table.getDealer().getHand().getHandValue() < 16 && table.getDealer().getHand().getHandValue() != -100) {
      table.deal(table.getDealer());
      dealerCards = table.getDealer().getHand().getCards();
      positionCards = table.getPosition().getHand().getCards();
      System.out.print("Dealer has"); 
      for (Card card : dealerCards) {
        System.out.print(" " + card.toString());
      }
      System.out.println();
      System.out.print("Your hand consists of");
      for (Card card : positionCards) {
        System.out.print(" " + card.toString());
      }
      System.out.println();
    }
    if (table.getDealer().getHand().getHandValue() == -100) {
      System.out.println("HOUSE BUSTS!");
      System.out.println("YOU WIN!");
    } else if (table.getDealer().getHand().getHandValue() > table.getPosition().getHand().getHandValue()) {
      System.out.println("HOUSE WINS!");
      System.out.println("YOU LOSE!");
    } else if (table.getDealer().getHand().getHandValue() == table.getPosition().getHand().getHandValue()) {
      System.out.println("GAME IS A PUSH!");
    } else if (table.getDealer().getHand().getHandValue() < table.getPosition().getHand().getHandValue()) {
      System.out.println("YOU WIN!");
      System.out.println("HOUSE LOSES!");
    }
  }
}

/*code to take mandatory initial bets*/
/*code adjusted to prompt user on what amount their initial bet will be*/