
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeckOfCards myDeck = new DeckOfCards(52, true); //keeps me from having to create a new one each time
		DeckOfCards useDeck = new DeckOfCards(52,false);
		useDeck = DeckOfCards.shuffle(myDeck);
		DeckOfCards myHand = DeckOfCards.deal1(useDeck, 5);
		Card checkCard;
		useDeck = DeckOfCards.deal2(myDeck, 5);
		for(int x = 0; x<myHand.deck.size();x++){
			checkCard = myHand.deck.get(x);
			if(checkCard.getRank()!=0){
				if(checkCard.getSuit() == 0){
					if(checkCard.getRank() == 1){
						System.out.println("Ace of Clubs");
					}
					else if(checkCard.getRank() == 11){
						System.out.println("Jack of Clubs");
					}
					else if(checkCard.getRank() == 12){
						System.out.println("Queen of Clubs");
					}
					else if(checkCard.getRank() == 13){
						System.out.println("King of Clubs");
					}
					else{
					System.out.println(checkCard.getRank() + " of Clubs");
					}
				}
				else if (checkCard.getSuit() == 1){
					if(checkCard.getRank() == 1){
						System.out.println("Ace of Diamonds");
					}
					else if(checkCard.getRank() == 11){
						System.out.println("Jack of Diamonds");
					}
					else if(checkCard.getRank() == 12){
						System.out.println("Queen of Diamonds");
					}
					else if(checkCard.getRank() == 13){
						System.out.println("King of Diamonds");
					}
					else{
					System.out.println(checkCard.getRank() + " of Diamonds");
					}
				}
				else if (checkCard.getSuit() == 2){
					if(checkCard.getRank() == 1){
						System.out.println("Ace of Hearts");
					}
					else if(checkCard.getRank() == 11){
						System.out.println("Jack of Hearts");
					}
					else if(checkCard.getRank() == 12){
						System.out.println("Queen of Hearts");
					}
					else if(checkCard.getRank() == 13){
						System.out.println("King of Hearts");
					}
					else{
					System.out.println(checkCard.getRank() + " of Hearts");
					}
				}
				else if (checkCard.getSuit() == 3){
					if(checkCard.getRank() == 1){
						System.out.println("Ace of Spades");
					}
					else if(checkCard.getRank() == 11){
						System.out.println("Jack of Spades");
					}
					else if(checkCard.getRank() == 12){
						System.out.println("Queen of Spades");
					}
					else if(checkCard.getRank() == 13){
						System.out.println("King of Spades");
					}
					else{
					System.out.println(checkCard.getRank() + " of Spades");
					}
				}
			}
		}
	}

}
