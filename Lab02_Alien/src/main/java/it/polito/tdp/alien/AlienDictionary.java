package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {

	List<WordEnhanced> dizionario;

	public AlienDictionary() {
		dizionario = new ArrayList<>();
	}

	public void addWord(String alienWord, String translation) {

		if (cerca(alienWord) != null) {
			cerca(alienWord).aggiungiTraduzione(translation);

			return; // esci
		}

		WordEnhanced w = new WordEnhanced(alienWord, translation);
		dizionario.add(w);

	}

	public String translateWord(String alienWord) {

		if (cerca(alienWord) != null) {
			WordEnhanced w = cerca(alienWord);

			return w.elencoTraduzioni();
		}

		return null;

	}

	private WordEnhanced cerca(String parolaAliena) {
		
		

		if (dizionario.contains(new WordEnhanced(parolaAliena, ""))) {
			int indice = dizionario.indexOf(new WordEnhanced(parolaAliena, ""));
			WordEnhanced w = dizionario.get(indice);

			return w;
		}

		return null;

	}

}
