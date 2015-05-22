package com.david.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardValue {
	
	private Map<String, Integer> deckValues = new HashMap<>();
	
	public CardValue(boolean blackjack) {
		
		String c = "";
		String d = "";
		String h = "";
		String s = "";
		
		//Set values to cards
		for(int i = 2; i <= 14; i++) {
        	c = Integer.toString(i) + "C";
        	d = Integer.toString(i) + "D";
        	h = Integer.toString(i) + "H";
        	s = Integer.toString(i) + "S";
        	deckValues.put(c, i);
    		deckValues.put(d, i);
    		deckValues.put(h, i);
    		deckValues.put(s, i);
		}
		
		//Change values for a blackjack game
		if(blackjack) {
			for(int i = 1; i <= 14; i++) {
				c = Integer.toString(i) + "C";
	        	d = Integer.toString(i) + "D";
	        	h = Integer.toString(i) + "H";
	        	s = Integer.toString(i) + "S";
	        	if(i == 1) {
	        		deckValues.put(c, i);
	        		deckValues.put(d, i);
	        		deckValues.put(h, i);
	        		deckValues.put(s, i);
	        	}
				if(i > 10 && i < 14) {
					deckValues.replace(c, i, 10);
					deckValues.replace(d, i, 10);
					deckValues.replace(h, i, 10);
					deckValues.replace(s, i, 10);
				}
				else if(i == 14) {
					deckValues.replace(c, i, 11);
					deckValues.replace(d, i, 11);
					deckValues.replace(h, i, 11);
					deckValues.replace(s, i, 11);
				}
			}
		}
	}
	
	public int getValueBJ(List<String> playerCards) {

        int total = 0;
        
        //Assign values to hand
        for(int i = 0; i < playerCards.size(); i++)
        	total += deckValues.get(playerCards.get(i));

        
        //If bust, change Ace to low
        if(total > 21) {
        	for(int i = 0; i < playerCards.size(); i++) {
        		if(playerCards.get(i).contains("14C"))
        			playerCards.set(i, "1C");
        		if(playerCards.get(i).contains("14D"))
        			playerCards.set(i, "1D");
        		if(playerCards.get(i).contains("14H"))
        			playerCards.set(i, "1H");
        		if(playerCards.get(i).contains("14S"))
        			playerCards.set(i, "1S");
        	}
        }
        
        //Re-evaluate total
        total = 0;
        for(int i = 0; i < playerCards.size(); i++)
        	total += deckValues.get(playerCards.get(i));
        
        return total;
	}
	
	public int getValueWar(List<String> playerCards) {
		
		int total = 0;
		
		for(int i = 0; i < playerCards.size(); i++)
        	total += deckValues.get(playerCards.get(i));
		
		return total;
	}

}
