import java.util.*;
public class Card {
	private int suit; //0 for clubs, 1 for diamonds, 2 for hearts, and 3 for spades
	private int rank; //1 is an ace, 2-10 are normal, 11 is a jack, 12 is a queen, and 13 is a king
	public Card(int cardSuit, int cardRank){
		suit = cardSuit;
		rank = cardRank;
	}
	public static ArrayList<Card> makeDeck(){
		ArrayList<Card> deck = new ArrayList<Card>();
		int x1 = 0;
		while(x1<52){ //whole deck
			for(int x2 = 0; x2 < 4; x2++){ //suit
				for(int x3 = 1; x3 < 14; x3++){ //rank, not using 0
					Card newCard = new Card(x2, x3);
					deck.add(newCard);
					x1++;
				}
			}
		}
		return deck;
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
