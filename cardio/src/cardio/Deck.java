package cardio;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	public ArrayList<Card> getDeck(){
		
		ArrayList<Card> dek = new ArrayList<Card>();
		
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				Card card = new Card();
				dek.add(card.getCard(i, j));
			}
		}
		
		Collections.shuffle(dek);
		
		return dek;
	}
	public void innerShufle(ArrayList<Card> list){
		ArrayList<Card> tempList = getDeck();
		
		for (int i = 0; i < tempList.size(); i++) {
			list.get(i).setBoth(tempList.get(i).getFace(), tempList.get(i).getValue());
		}
	}
}
