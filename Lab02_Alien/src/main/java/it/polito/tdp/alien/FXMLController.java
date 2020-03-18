package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class FXMLController {

	private AlienDictionary dizionario; // INIZIALIZZO

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtInserisci;

	@FXML
	private Button btnTraduci;

	@FXML
	private TextArea txtRisultato;

	@FXML
	private Button btnPulisci;

	@FXML
	void doReset(ActionEvent event) {
		txtRisultato.clear();

	}

	@FXML
    void doTranslate(ActionEvent event) {
    	
    	String inserimento[] = txtInserisci.getText().toLowerCase().split(" ");
    	
    	if(inserimento.length==1) //una sola parola -> tradurre
    	{
    		String alienWord= inserimento[0];
    		if( valoriCorretti(alienWord))
    		{
    			
    			String tradotta= this.dizionario.translateWord(alienWord);
    			
    			if(tradotta!= null)
    			{
    				txtRisultato.setText(tradotta +"\n");
    				
    			}
    			else
    			{
    				txtRisultato.setText("Parola non presente");
    			}
    		}
    		else
    		{
    			//errore
    			txtRisultato.setText("Testo inserito nel formato sbagliato \n");
    		}
    		
    		
    		
    		
    	}else if(inserimento.length==2)
    	{
    		String alienWord= inserimento[0];
    		String translation=	inserimento[1];
    		
    		if( valoriCorretti(alienWord) &&	valoriCorretti(translation))
    				{
    			
    					this.dizionario.addWord(alienWord, translation);
    					txtRisultato.setText("Parola inserita");
    			
    				}
    		else {
    			//errore
    			txtRisultato.setText("Testo inserito nel formato sbagliato \n");
    		}
    		
    	}
    	
    	

    }

	private boolean valoriCorretti(String controllare) {

		for (int i = 0; i < controllare.length(); i++) {
			char c = controllare.charAt(i);
			if (!Character.isLetter(c)) {

				return false; // appena non va bene, esce

			}

		}
		return true;

	}

	
	  @FXML
	    void initialize() {
	        assert txtInserisci != null : "fx:id=\"txtInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert btnTraduci != null : "fx:id=\"btnTraduci\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
	        assert btnPulisci != null : "fx:id=\"btnPulisci\" was not injected: check your FXML file 'Scene.fxml'.";

	  
		this.dizionario = new AlienDictionary();
	}
}
