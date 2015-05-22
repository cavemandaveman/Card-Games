package com.david.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardIconsHTML {
	
	private Map<String, String> icons = new HashMap<>();
	
	public CardIconsHTML() {
		icons.put("14S", "&#127137");
		icons.put("1S", "&#127137");
		icons.put("2S", "&#127138");
		icons.put("3S", "&#127139");
		icons.put("4S", "&#127140");
		icons.put("5S", "&#127141");
		icons.put("6S", "&#127142");
		icons.put("7S", "&#127143");
		icons.put("8S", "&#127144");
		icons.put("9S", "&#127145");
		icons.put("10S", "&#127146");
		icons.put("11S", "&#127147");
		icons.put("12S", "&#127149");
		icons.put("13S", "&#127150");
		icons.put("14H", "&#127153");
		icons.put("1H", "&#127153");
		icons.put("2H", "&#127154");
		icons.put("3H", "&#127155");
		icons.put("4H", "&#127156");
		icons.put("5H", "&#127157");
		icons.put("6H", "&#127158");
		icons.put("7H", "&#127159");
		icons.put("8H", "&#127160");
		icons.put("9H", "&#127161");
		icons.put("10H", "&#127162");
		icons.put("11H", "&#127163");
		icons.put("12H", "&#127165");
		icons.put("13H", "&#127166");
		icons.put("14D", "&#127169");
		icons.put("1D", "&#127169");
		icons.put("2D", "&#127170");
		icons.put("3D", "&#127171");
		icons.put("4D", "&#127172");
		icons.put("5D", "&#127173");
		icons.put("6D", "&#127174");
		icons.put("7D", "&#127175");
		icons.put("8D", "&#127176");
		icons.put("9D", "&#127177");
		icons.put("10D", "&#127178");
		icons.put("11D", "&#127179");
		icons.put("12D", "&#127181");
		icons.put("13D", "&#127182");
		icons.put("14C", "&#127185");
		icons.put("1C", "&#127185");
		icons.put("2C", "&#127186");
		icons.put("3C", "&#127187");
		icons.put("4C", "&#127188");
		icons.put("5C", "&#127189");
		icons.put("6C", "&#127190");
		icons.put("7C", "&#127191");
		icons.put("8C", "&#127192");
		icons.put("9C", "&#127193");
		icons.put("10C", "&#127194");
		icons.put("11C", "&#127195");
		icons.put("12C", "&#127197");
		icons.put("13C", "&#127198");
	}
	
	public String icons(List<String> cards) {
		
		String cardIcons = "";
		
		for(int i = 0; i < cards.size(); i++)
			cardIcons += (icons.get(cards.get(i)) + " ");
		
		return cardIcons;
	}

}
