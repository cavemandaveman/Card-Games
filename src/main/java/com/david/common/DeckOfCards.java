package com.david.common;

import java.util.LinkedList;

public class DeckOfCards {
	
	private LinkedList<String> deck = new LinkedList<>();
	
	public DeckOfCards() {

		for(int i = 2; i <= 14; i++) {
			String c = Integer.toString(i) + "C";
			String d = Integer.toString(i) + "D";
			String h = Integer.toString(i) + "H";
			String s = Integer.toString(i) + "S";
			deck.add(c);
			deck.add(d);
			deck.add(h);
			deck.add(s);
		}
	}
	
	public LinkedList<String> getDeck() {
		return deck;
	}

}
