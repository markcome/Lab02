package it.polito.tdp.alien;

public class AlienDictionary {
	
	private String alienWord;
	private String translation;
	
	public AlienDictionary(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation = translation;
	}

	public void updateTranslation(String translation){
		 this.translation = translation;
	}
	
	public String getTranslation(){
		return this.translation;
	}
}
