package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {

	List<WordEnhanced> dizionario;

	public AlienDictionary() {
		dizionario = new ArrayList<>();
	}

	public void addWord(String alienWord, String translation) {

		if (cerca(alienWord).size() > 0) {
			// sicuramente cerca(alienWord) ha o un componente o 0

			WordEnhanced w = cerca(alienWord).get(0);

			w.aggiungiTraduzione(translation);

			return; // esci
		}

		WordEnhanced w = new WordEnhanced(alienWord, translation);
		dizionario.add(w);

	}

	public String translateWord(String alienWord) {

		if (cerca(alienWord).size()>0) {
			List<WordEnhanced> w = cerca(alienWord);

			String s = "";

			for (WordEnhanced we : w) {
				s += we.elencoTraduzioni();

			}
			return s;
		}

		return null;

	}

	private List<WordEnhanced> cerca(String parolaAliena) {

		List<WordEnhanced> listaCerca = new LinkedList<>();

		if (!parolaAliena.contains("?")) {

			WordEnhanced temp = new WordEnhanced(parolaAliena, "");

			if (dizionario.contains(temp)) {
				int indice = dizionario.indexOf(temp);
				WordEnhanced w = dizionario.get(indice);
				listaCerca.add(w);

				return listaCerca;
			}

		
		} else {
			int nPunti = 0;
			// devo essere sicura ci sia un "?"
			for (int i = 0; i < parolaAliena.length(); i++) {

				if (parolaAliena.charAt(i) == '?')
					nPunti++;

			}

			if (nPunti == 1) {

				int indice = parolaAliena.indexOf("?");
				String nuovaAltro = parolaAliena.replace('?', ' ').trim();

				for (WordEnhanced w : dizionario) { // equals diventa difficile

					String nuova = w.getAlienWord().replace(w.getAlienWord().charAt(indice), ' ').trim();

					if (nuova.equals(nuovaAltro)) {
						listaCerca.add(w);

					}

				}
				return listaCerca;

			}

			
		}
		return listaCerca;

	}

}
