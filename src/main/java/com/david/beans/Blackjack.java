package com.david.beans;

import org.springframework.context.annotation.Scope;

import com.david.blackjack.BJRound;

@Scope("session")
public class Blackjack {
	
	private BJRound round = new BJRound();;
	private String p1Cards;
	private String dealerCards;
	
	public void setDeal() {
		round.deal();
		p1Cards = round.getP1Cards();
		dealerCards = round.getDealerCards();
	}
	public void setHit() {
		round.hit();
		p1Cards = round.getP1Cards();
		dealerCards = round.getDealerCards();
	}
	public void setStay() {
		round.stay();
		p1Cards = round.getP1Cards();
		dealerCards = round.getDealerCards();
	}
	public String getP1Cards() {
		return p1Cards;
	}
	public String getDealerCards() {
		return dealerCards;
	}
	public String getValueP1() {
		return round.getP1Value();
	}
	public String getValueDealer() {
		return round.getDealerValue();
	}
	public String getWins() {
		return round.getWins();
	}

}
