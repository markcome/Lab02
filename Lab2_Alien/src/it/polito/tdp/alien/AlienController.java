package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private String alienWord;
	private String translation;
	private Map<String, AlienDictionaryAdvanced> alienDictionary;
	
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	this.alienDictionary = new TreeMap<String, AlienDictionaryAdvanced>();
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) { 
    		String insert = this.txtWord.getText();
    		String parola1;
    		String parola2;
    		String array[] = insert.split(" ");
    			
    		try{
    			if(array.length == 1 && this.checkLetters(array[0])){
    				//cerco traduzione
    				this.txtResult.setText(this.alienDictionary.get(array[0].toLowerCase()).getTranslations());
    			}else if(array.length == 2 && this.checkLetters(array[0]) && this.checkLetters(array[1])){
    				//aggiungo al dizionario
    				if(this.alienDictionary.get(array[0].toLowerCase()) != null){
    					this.alienDictionary.get(array[0].toLowerCase()).addTranslation(array[1].toLowerCase());
    					this.txtResult.setText("Vocabolo aggiornato");
    				}else{
	    				this.alienDictionary.put(array[0].toLowerCase(), new AlienDictionaryAdvanced(array[0].toLowerCase(), array[1].toLowerCase()));
	    				this.txtResult.setText("Aggiunto a vocabolario");
    				}
    			}else{
    				this.txtResult.insertText(0, "!!Errore nell'inserimento!!\n");
    			}
    		}catch (NullPointerException npe){
    			this.txtResult.setText("Inserisci almeno una parola");
    		}
    }
    
    private boolean checkLetters (String stringa){
    		char[] caratteri = stringa.toCharArray();
    		for(char c: caratteri)
    			if(!Character.isLetter(c))
    				return false;
    	return true;
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	this.txtResult.clear();
    	this.txtWord.clear();
    }
    
}
