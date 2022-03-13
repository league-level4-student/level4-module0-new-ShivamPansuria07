package _06_Card_Game;

import java.util.ArrayList;
import java.util.Random;

public class CardDealer {
    ArrayList<Card> deck;
    enum Cards {

    	suit(1), rank(value);
    	
    	private final int value;
    	 private Cards(int value) {
            this.value = value;
        }
    }
   
}
