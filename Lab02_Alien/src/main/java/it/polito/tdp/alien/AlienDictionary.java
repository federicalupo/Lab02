package it.polito.tdp.alien;
import java.util.*;

public class AlienDictionary {
	
	List<Word> dizionario;
	
	

	public AlienDictionary() {
		dizionario= new ArrayList<>();
	}

	public void addWord(String alienWord, String translation) {
		
		
	//	if(dizionario.contains(alienWord)) NOOOOOO
		
		if(cerca(alienWord)!=null)
		{
			cerca(alienWord).setTranslation(translation);
					
			return; //esci
		}
		
		Word w= new Word(alienWord, translation);
		dizionario.add(w);
	
	}
	
	public String translateWord(String alienWord) {
		
		
		if(cerca(alienWord)!=null)
		{
			Word w= cerca(alienWord);
			return w.getTranslation();
		}
		
		
		return null;
		
	}
	
	
	private Word cerca (String parolaAliena) {
		
		if(dizionario.contains(new Word (parolaAliena, "")))
		{
			int indice= dizionario.indexOf(new Word(parolaAliena, ""));
			Word w= dizionario.get(indice);
			
			return w;
		}
		
		
		return null;
		
	}
	
	
	
	
}
