package com.david.cardgames;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.david.beans.Blackjack;
import com.david.beans.War;
import com.david.beans.War2;
import com.david.war.WarRound;
import com.david.war.WarRound2;

@Controller
@Scope("session")
@SessionAttributes({"name"})
public class GameController {
	
	@Autowired
	private Blackjack bj;
	@Autowired
	private War war;
	private War2 bean;
	
	@RequestMapping(value = "/poker", method = RequestMethod.GET)
	public String pokerGET() {
		
		return "poker";
	}
	@RequestMapping(value = "/poker", method = RequestMethod.POST)
	public String pokerPOST(Model model, @RequestParam(required=false) Integer players, @RequestParam(required=false) Double ante, 
			@RequestParam(required=false) Double wallet) {

		if(ante == null || ante <= 0) {
			model.addAttribute("anteError", "true");
			return "poker";
		}
		if(wallet == null || wallet < ante*3.0) {
			model.addAttribute("walletError", "true");
			return "poker";
		}

		model.addAttribute("check", "post");
		return "poker";
	}
	
	@RequestMapping(value = "/blackjack", method = RequestMethod.GET)
	public String bjGET() {
		
		return "blackjack";
	}
	@RequestMapping(value = "/blackjack", method = RequestMethod.POST)
	public String bjPOST(Model model, @RequestParam(required=false) Integer rounds, 
			@RequestParam(required=false) String dealt, @RequestParam(required=false) String hit,
			@RequestParam(required=false) String stay) {
		
		if(rounds == null) {
			model.addAttribute("error", "true");
			return "blackjack";
		}
		if(dealt != null && dealt.equals("true")) {
			bj.setDeal();
			model.addAttribute("p1Cards", bj.getP1Cards());
			model.addAttribute("dealerCards", bj.getDealerCards());
			model.addAttribute("p1Value", bj.getValueP1());
			model.addAttribute("dealerValue", bj.getValueDealer());
			model.addAttribute("wins", bj.getWins());
		}
		else if(hit != null && hit.equals("true")) {
			bj.setHit();
			String p1Count = bj.getValueP1();
			String dealerCount = bj.getValueDealer();
			if(Integer.parseInt(p1Count) > 21) {
				model.addAttribute("bust", "BUST!");
				bj.setStay();
			}
			if(Integer.parseInt(dealerCount) > 21)
				model.addAttribute("dealerBust", "BUST!");
			model.addAttribute("p1Cards", bj.getP1Cards());
			model.addAttribute("dealerCards", bj.getDealerCards());
			model.addAttribute("p1Value", p1Count);
			model.addAttribute("dealerValue", dealerCount);
			model.addAttribute("wins", bj.getWins());
		}
		else if(stay != null && stay.equals("true")) {
			bj.setStay();
			String dealerCount = bj.getValueDealer();
			if(Integer.parseInt(dealerCount) > 21)
				model.addAttribute("dealerBust", "BUST!");
			model.addAttribute("p1Cards", bj.getP1Cards());
			model.addAttribute("dealerCards", bj.getDealerCards());
			model.addAttribute("p1Value", bj.getValueP1());
			model.addAttribute("dealerValue", dealerCount);
			model.addAttribute("wins", bj.getWins());
		}

		model.addAttribute("check", "post");
		return "blackjack";
	}
	
	@RequestMapping(value = "/war", method = RequestMethod.GET)
	public String warGET() {
		
		return "war";
	}
	@RequestMapping(value = "/war", method = RequestMethod.POST)
	public String warPOST(Model model, @RequestParam(required=false) String dealt, 
			@RequestParam(required=false) String battle) {
		
		if(dealt != null && dealt.equals("true")) {
			war.setDeal();
			model.addAttribute("p1Hand", war.getP1Hand());
			model.addAttribute("cpuHand", war.getCPUHand());
			String p1Total = war.getP1Total();
			model.addAttribute("p1Total", p1Total);
			model.addAttribute("cpuTotal", war.getCPUTotal());
			if(war.checkWar())
				model.addAttribute("battle", "true");
			if(Integer.parseInt(p1Total) == 52)
				model.addAttribute("winner", "You Win!");
			else if(Integer.parseInt(p1Total) == 0)
				model.addAttribute("winner", "You Lose!");
		}
		if(battle != null && battle.equals("true")) {
			war.setWar();
			model.addAttribute("p1Hand", war.getP1Hand());
			model.addAttribute("cpuHand", war.getCPUHand());
			String p1Total = war.getP1Total();
			model.addAttribute("p1Total", p1Total);
			model.addAttribute("cpuTotal", war.getCPUTotal());
			model.addAttribute("blankCards", "&#127136 &#127136 &#127136");
			if(war.checkWar())
				model.addAttribute("battle", "true");
			else
				model.addAttribute("dealt", "true");
			if(Integer.parseInt(p1Total) == 52)
				model.addAttribute("winner", "You Win!");
			else if(Integer.parseInt(p1Total) == 0)
				model.addAttribute("winner", "You Lose!");
		}
		
		model.addAttribute("check", "post");
		return "war";
	}
	
	//Bean attempt
	@RequestMapping(value = "/war", method = RequestMethod.POST)
	public String warBeanExample(Model model, @RequestParam(required=false) String dealt, 
			@RequestParam(required=false) String battle) {
		
		WarRound2 wr = new WarRound2();
		
		wr.deal();
		bean.setCards(wr.getP1Hand());
		
		return "war";
	}

}
