package it.polito.tdp.alien;

import java.util.*;



public class WordEnhanced {

	private String alienWord;
	private List<String> traduzioni = new ArrayList<>();;

	public WordEnhanced(String alienWord, String translation) {
		this.alienWord = alienWord;
		traduzioni.add(translation);
	}

	@Override
	public boolean equals(Object obj) {
		
		WordEnhanced alieno = (WordEnhanced) obj; // parola alien
		String parola= alieno.alienWord;
		

		if (this.alienWord.equals(parola))
			return true;

		return false;

	}

	public void aggiungiTraduzione(String translation) {

		
		if (!traduzioni.contains(translation)) {
			this.traduzioni.add(translation);

		}

	}

	public String elencoTraduzioni() {
		String s = "";

		for (String temp : traduzioni) {
			s += temp + "\n";
		}

		return s;

	}

	public String getAlienWord() {
		return alienWord;
	}
	
	
	
	

}
