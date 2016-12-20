
public class War {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeckOfCards myDeck = new DeckOfCards(52, true); //keeps me from having to create a new one each time in case I loop the program
		DeckOfCards useDeck = new DeckOfCards(52,false);
		useDeck = DeckOfCards.shuffle(myDeck);
		DeckOfCards hand1 = DeckOfCards.deal1(useDeck, 26);
		useDeck = DeckOfCards.deal2(myDeck, 26);
		DeckOfCards hand2 = DeckOfCards.deal1(useDeck, 26);
		useDeck = DeckOfCards.deal2(useDeck, 26);
		Card play1;
		Card play2;
		Card play3; //drawn by 1 twice in a war, should NEVER be seen the first time
		Card play4; //drawn by 2 twice in a war, should NEVER be seen the first time
		DeckOfCards warPile = new DeckOfCards(0, false); //for card drawn in a war
		int count = 0;
		while(!(hand1.deck.size() == 0 || hand2.deck.size() == 0)){ //while neither of them have lost all their cards
			count++;
			System.out.println("Round " + count);
			play1 = hand1.deck.get(0);
			play2 = hand2.deck.get(0);
			hand1.deck.remove(0);
			hand2.deck.remove(0);
			int rank1 = play1.getRank();
			int rank2 = play2.getRank();
			System.out.println(rank1 + " vs " + rank2);
			if((rank1 > rank2 && rank2!=1) || (rank1 == 1 && rank2!=1)){ //rank1 wins
				System.out.println("Player 1 wins!");
				hand1.deck.add(play1);
				hand1.deck.add(play2);
			}
			else if((rank2 > rank1 && rank1!=1) || (rank2 == 1 && rank1!=1)){ //rank2 wins
				System.out.println("Player 2 wins!");
				hand2.deck.add(play1);
				hand2.deck.add(play2);
			}
			else if(rank1 == rank2){ //tie. This SHOULD be every other case technically, but I have to be sure
				System.out.println("It's a tie! WAR!");
				play3 = hand1.deck.get(0);
				hand1.deck.remove(0);
				warPile.deck.add(play3); //this card is NEVER seen
				play3 = hand1.deck.get(0); //this card is used
				hand1.deck.remove(0);
				play4 = hand2.deck.get(0);
				hand2.deck.remove(0);
				warPile.deck.add(play4); //this card is NEVER seen
				play4 = hand1.deck.get(0); //this card is used
				hand2.deck.remove(0);
				int rank3 = play3.getRank();
				int rank4 = play4.getRank();
				System.out.println(rank3 + " vs " + rank4);
				if(rank3 == rank4){//if these tie, it loops putting them down over and over and checking. If one has no more cards, the other wins
					while(!(hand1.deck.size() == 0 || hand2.deck.size() == 0)){
						warPile.deck.add(play3);
						warPile.deck.add(play4);//put those tie cards into the pile
						play3 = hand1.deck.get(0); 
						hand1.deck.remove(0);
						play4 = hand2.deck.get(0);
						hand2.deck.remove(0);
						rank3 = play3.getRank();
						rank4 = play4.getRank();
						System.out.println("War, " + rank3 + " vs " + rank4);
						if(!(rank3 == rank4)){ //it doesn't tie, and the loop breaks
							if((rank1 > rank2 && rank2!=1) || (rank1 == 1 && rank2!=1)){ //rank1 wins
								System.out.println("Player 1 wins the war! He gets all cards!");
								while(!(warPile.deck.size() == 0)){
									hand1.deck.add(warPile.deck.get(0));
									warPile.deck.remove(0);
								}
								hand1.deck.add(play3);
								hand1.deck.add(play4);
							}
							else{ //any other cases allowed here are a rank2 victory
								System.out.println("Player 2 wins the war! He gets all cards!");
								while(!(warPile.deck.size() == 0)){
									hand2.deck.add(warPile.deck.get(0));
									warPile.deck.remove(0);
								}
								hand2.deck.add(play3);
								hand2.deck.add(play4);
							}
						}
					}
				}
			}
			else{ //just in case
				System.out.println("ERROR");
			}
		}
		if(hand2.deck.size() == 0){ //Player 1 wins
			System.out.println("Player 1 WINS! Here is his deck: ");
			for(int x = 0; x<hand1.deck.size();x++){
				Card check = hand1.deck.get(x);
				System.out.println(check.getSuit() +" " + check.getRank());
			}
		}
		else if(hand1.deck.size() == 0){ //Player 2 wins
			System.out.println("Player 2 WINS! Here is his deck: ");
			for(int x = 0; x<hand2.deck.size();x++){
				Card check = hand2.deck.get(x);
				System.out.println(check.getSuit() +" " + check.getRank());
			}
		}
	}

}
