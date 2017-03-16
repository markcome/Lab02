package it.polito.tdp.alien;

import java.util.LinkedList;

public class AlienDictionaryAdvanced {

	private String alienWord;
	private LinkedList<String> translation = new LinkedList<String>();
	
	public AlienDictionaryAdvanced(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation.add(translation);
	}

	public void addTranslation(String translation){
		 if(this.searchTransaltion(translation) == null)
			 this.translation.add(translation);
	}
	
	private String searchTransaltion(String translation){
		for(String s: this.translation)
			if(s.compareTo(translation) == 0)
				return s;
		return null;
	}
	
	public String getTranslations(){
		String stringa = new String();
		int i = 0;
		for(String s: translation){
			if(i == 0){
				stringa += s;
				i++;
			}else
				stringa += "\n" + s;
		}
		return stringa;
	}
}
