import java.util.*;
public class DeckOfCards {
	ArrayList<Card> deck = new ArrayList<Card>();
	public DeckOfCards(int num, boolean makeDeck){
		if(num == 52 && makeDeck){
			deck = Card.makeDeck();
		}
		else {
			for(int j = 0; j<num; j++){
				Card dummyCard = new Card(0,0);
				deck.add(dummyCard);
			}
		}
	}
	public static DeckOfCards shuffle(DeckOfCards myDeck){
		DeckOfCards shuffled = new DeckOfCards(52, false);
		//for(int o = 0; o<52; o++){
			//Card checkCard = shuffled.deck.get(o);
			//System.out.println(checkCard.getSuit() + " " + checkCard.getRank());
		//}
		DeckOfCards useDeck = myDeck;
		int random;
		Card testCard;
		Random rndm = new Random();
		int j=0;
		while(j<52){
			//System.out.println(j);
			random = rndm.nextInt(52);
			testCard = shuffled.deck.get(random);
			//System.out.println(testCard.getSuit() + " " + testCard.getRank());
			if(testCard.getRank() == 0){
				shuffled.deck.set(random, useDeck.deck.get(j));
				j++;
			}
			else{
				continue;
			}
			
		}
		//for(int o = 0; o<52; o++){
			//Card checkCard = shuffled.deck.get(o);
			//System.out.println(checkCard.getSuit() + " " + checkCard.getRank());
		//}
		return shuffled;
	}
	public static DeckOfCards deal1(DeckOfCards myDeck, int hand){ //myHand will equal this. Use in conjunction with deal2
		DeckOfCards yourHand = new DeckOfCards(hand, false);
		for(int x = 0; x<hand;x++){
			yourHand.deck.set(x, myDeck.deck.get(x));
		}
		return yourHand;
	}
	public static DeckOfCards deal2(DeckOfCards myDeck, int hand){ //to be used together with deal1
		DeckOfCards newDeck = new DeckOfCards(myDeck.deck.size() - hand, false);
		int j = 0;
		for(int x = hand; x<myDeck.deck.size(); x++){
			newDeck.deck.set(j, myDeck.deck.get(x));
			j++;
		}
		return newDeck;
	}
}
