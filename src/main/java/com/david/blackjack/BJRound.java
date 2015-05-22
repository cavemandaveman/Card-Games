package com.david.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import com.david.common.CardIconsHTML;
import com.david.common.CardValue;
import com.david.common.DeckOfCards;

public class BJRound {

	private LinkedList<String> deck = new LinkedList<>();
	private List<String> p1Cards = new ArrayList<>();
	private List<String> dealerCards = new ArrayList<>();
	private CardValue cv = new CardValue(true);
	private CardIconsHTML ci = new CardIconsHTML();
	private int wins;
	
	public void deal() {
	
		deck = new DeckOfCards().getDeck();
		
		Collections.shuffle(deck);
	
		p1Cards.clear();
		dealerCards.clear();
		
		p1Cards.add(deck.remove());
		p1Cards.add(deck.remove());
		
		dealerCards.add(deck.remove());
	}
	
	public void hit() {
		
		int total = cv.getValueBJ(p1Cards);
		if(total < 21)
			p1Cards.add(deck.remove());
	}
	
	public void stay() {
		
		int p1CardTotal = cv.getValueBJ(p1Cards);
		int dealerCardTotal = cv.getValueBJ(dealerCards);
		while(dealerCardTotal <= 17) {
			dealerCards.add(deck.remove());
			dealerCardTotal = cv.getValueBJ(dealerCards);
		}

		if((p1CardTotal > dealerCardTotal && p1CardTotal <= 21) || (p1CardTotal <= 21 && dealerCardTotal > 21))
			wins++;;
	}
	
	public String getDealerCards() {
		return ci.icons(dealerCards);
	}
	public String getP1Cards() {
		return ci.icons(p1Cards);
	}
	public String getP1Value() {
		int total = cv.getValueBJ(p1Cards);
		return Integer.toString(total);
	}
	public String getDealerValue() {
		int total = cv.getValueBJ(dealerCards);
		return Integer.toString(total);
	}
	public String getWins() {
		return Integer.toString(wins);
	}

}
