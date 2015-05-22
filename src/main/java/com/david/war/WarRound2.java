package com.david.war;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import com.david.common.CardIconsHTML;
import com.david.common.CardValue;
import com.david.common.DeckOfCards;

public class WarRound2 {
	
	private LinkedList<String> deck = new LinkedList<>();
	private LinkedList<String> p1Stack = new LinkedList<>();
	private LinkedList<String> cpuStack = new LinkedList<>();
	private LinkedList<String> tempStack = new LinkedList<>();
	private List<String> p1Hand = new ArrayList<>();
	private List<String> cpuHand = new ArrayList<>();
	private CardValue cv = new CardValue(false);
	private CardIconsHTML ci = new CardIconsHTML();
	private int p1Value;
	private int cpuValue;
	private boolean war;
	
	public WarRound2() {
		
		deck = new DeckOfCards().getDeck();
		Collections.shuffle(deck);
		
		while(p1Stack.size() < 26) {
			p1Stack.add(deck.remove());
			cpuStack.add(deck.remove());
		}
	}
	
	public void deal() {
		
		if(p1Stack.size() < 52 && p1Stack.size() > 0) {
			p1Hand.clear();
			p1Hand.add(p1Stack.remove());

			cpuHand.clear();
			cpuHand.add(cpuStack.remove());

			setValuesAndWar();
		}
	}
	
	public void war() {
		
		if(p1Stack.size() < 48 && p1Stack.size() > 4) {
			tempStack.addAll(p1Hand);
			p1Hand.clear();
			tempStack.addAll(cpuHand);
			cpuHand.clear();

			for(int i = 0; i < 3; i++) {
				tempStack.add(p1Stack.remove());
				tempStack.add(cpuStack.remove());
			}

			p1Hand.add(p1Stack.remove());
			cpuHand.add(cpuStack.remove());

			war = false;

			setValuesAndWar();
		}
	}
	
	public void setValuesAndWar() {
		
		p1Value = cv.getValueWar(p1Hand);
		cpuValue = cv.getValueWar(cpuHand);
		
		if(p1Value == cpuValue) {
			war = true;
		}
		else if(p1Value > cpuValue) {
			p1Stack.add(cpuHand.get(0));
			p1Stack.add(p1Hand.get(0));
			p1Stack.addAll(tempStack);
			tempStack.clear();
			war = false;
		}
		else {
			cpuStack.add(p1Hand.get(0));
			cpuStack.add(cpuHand.get(0));
			cpuStack.addAll(tempStack);
			tempStack.clear();
			war = false;
		}
	}
	
	public boolean checkWar() {
		return war;
	}
	public String getCPUHand() {
		return ci.icons(cpuHand);
	}
	public String getP1Hand() {
		return ci.icons(p1Hand);
	}
	public String getCPUTotal() {
		return Integer.toString(cpuStack.size());
	}
	public String getP1Total() {
		return Integer.toString(p1Stack.size());
	}

}
