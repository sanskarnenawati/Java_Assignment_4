// Name : Sanskar Nenawati
// Prn : 21070126077
// Branch: AIML B1
import java.util.Scanner;
import java.util.Vector;
import java.util.Random;

class Card {
    private int ranks;
    private int suit;

    public Card() {
        this.ranks = 0;
        this.suit = 0;
    }

    public Card(int ranks, int suit) {
        this.ranks = ranks;
        this.suit = suit;
    }

    public int getranks() {
        return ranks;
    }

    public int getSuit() {
        return suit;
    }

    public void printCard() {
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] rankss = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        System.out.println(rankss[this.ranks] + " of " + suits[this.suit]);
    }

    public static Vector<Card> createDeck() {
        Vector<Card> deck = new Vector<Card>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck.add(new Card(j, i));
            }
        }
        return deck;
    }

    public static void printDeck(Vector<Card> deck) {
        for (Card card : deck) {
            card.printCard();
        }
    }

    public boolean sameCard(Card other) {
        return (this.ranks == other.ranks && this.suit == other.suit);
    }

    public int compareCard(Card other) {
        if (this.ranks < other.ranks) {
            return -1;
        } else if (this.ranks > other.ranks) {
            return 1;
        } else {
            if (this.suit < other.suit) {
                return -1;
            } else if (this.suit > other.suit) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void sortDeck(Vector<Card> deck) {
        deck.sort((c1, c2) -> c1.compareCard(c2));
    }

    public static void findCard(Vector<Card> deck, Card card) {
        for (int i = 0; i < deck.size(); i++) {
            if (deck.get(i).sameCard(card)) {
                System.out.println("Card found at index " + i);
                return;
            }
        }
        System.out.println("Card not found");
    }

    public static void dealCards(Vector<Card> deck) {
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int index = rand.nextInt(deck.size());
            Card card = deck.get(index);
            card.printCard();
            deck.remove(index);
        }
    }
}

public class CardG {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Vector<Card> deck = Card.createDeck();

        while (true) {
            System.out.println("1. Print the deck");
            System.out.println("2. Check if two cards are the same");
            System.out.println("3. Sort the deck");
            System.out.println("4. Find a card");
            System.out.println("5. Deal cards");
            System.out.println("6. Exit");
            int choice = input.nextInt();

            if (choice == 1) {
                System.out.println(" Deck :");
                Card.printDeck(deck);

            } else if (choice == 2) {
                System.out.println("\nEnter the first card:");
                Card card1 = readCard(input);
                System.out.println("Enter the second card:");
                Card card2 = readCard(input);
                if (card1.sameCard(card2)) {
                    System.out.println("The two cards are the same");
                } else {
                    System.out.println("The two cards are different");
                }

            } else if (choice == 3) {
                Card.sortDeck(deck);
                System.out.println(" Sorted deck :");
                Card.printDeck(deck);

            } else if (choice == 4) {
                System.out.println("\nEnter a card to search for:");
                Card card = readCard(input);
                Card.findCard(deck, card);

            } else if (choice == 5) {
                System.out.println("\nDealing cards...");
                Card.dealCards(deck);

            } else if (choice == 6) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice, try again");
            }
        }
    }

    public static Card readCard(Scanner input) {
        System.out.print("Enter ranks (0-12): ");
        int ranks = input.nextInt();
        System.out.print("Enter suit (0-3): ");
        int suit = input.nextInt();
        return new Card(ranks, suit);
    }
}
