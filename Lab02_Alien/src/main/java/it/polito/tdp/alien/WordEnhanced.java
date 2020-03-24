package it.polito.tdp.alien;

import java.util.*;



//MODIFICHE DA FARE: FARE IN MODO DI SALVARE SUBITO LISTA DI TRADUZIONI, SE VIENE RIMESSA PAROLA E ALTRE TRADUZIONI
//QUESTE VENGONO RIMPOSTATE







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
		
		
		if(parola.contains("?"))
		{
			
			int i=parola.indexOf("?");
			
			String nuovaAltro= parola.replace('?', ' ').trim();
			
			String nuova=this.alienWord.replace(alienWord.charAt(i), ' ').trim();
			
			
			if(nuova.equals(nuovaAltro))
				return true;
			
			return false;
			
			
		}

		

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

}
