package it.polito.tdp.alien;

public class Word {
	
	private String alienWord;
	private String translation;
	
	
	
	
	
	
	public Word(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation = translation;
	}

	


	public String getTranslation() {
		return translation;
	}




	public void setTranslation(String translation) {
		this.translation = translation;
	}




	@Override
	public boolean equals(Object obj) {
		
		Word alieno= (Word) obj; //parola aliena
		
		if(this.alienWord.compareTo(alieno.alienWord)==0)
			return true;
		
		
		return false;
		

	}
	
	
	
	
	

}
