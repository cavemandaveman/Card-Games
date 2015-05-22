package com.david.beans;

import org.springframework.context.annotation.Scope;

import com.david.war.WarRound;

@Scope("session")
public class War {
	
	private WarRound round = new WarRound();
	private String p1Hand;
	private String cpuHand;
	
	public void setDeal() {
		round.deal();
		p1Hand = round.getP1Hand();
		cpuHand = round.getCPUHand();
	}
	public void setWar() {
		round.war();
		p1Hand = round.getP1Hand();
		cpuHand = round.getCPUHand();
	}

	public String getP1Hand() {
		return p1Hand;
	}
	public String getCPUHand() {
		return cpuHand;
	}
	public String getP1Total() {
		return round.getP1Total();
	}
	public String getCPUTotal() {
		return round.getCPUTotal();
	}
	public boolean checkWar() {
		return round.checkWar();
	}
}
