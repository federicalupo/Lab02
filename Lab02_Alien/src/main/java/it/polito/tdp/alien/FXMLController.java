package it.polito.tdp.alien;

import java.net.URL;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

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

		String inserimento = txtInserisci.getText().toLowerCase();

		StringTokenizer st = new StringTokenizer(inserimento, " ");
		// conto tokens subito!

		int cont = st.countTokens();

		String parolaAliena = st.nextToken();

		// se conto tokens qui, non è corretto

		if (valoriCorretti(parolaAliena)) {

			if (cont == 1) // un elemento -> traduzione

			{

				String tradotta = this.dizionario.translateWord(parolaAliena);

				if (tradotta != null) {
					txtRisultato.setText(tradotta);

				} else {
					txtRisultato.setText("Parola non presente");
				}

				return;
			}

			String traduzione = st.nextToken();

			while (traduzione != null) {

				if (this.valoriCorretti(traduzione)) {
					this.dizionario.addWord(parolaAliena, traduzione);

					txtRisultato.setText("Inserita traduzione");

					try {
						traduzione = st.nextToken();
					} catch (NoSuchElementException nse) {
						return;
					}

				} else {
					txtRisultato.setText("Testo inserito nel formato sbagliato \n");
					return; // !!!!!!! se no è un loop

				}

			}

		} else {
			txtRisultato.setText("Testo inserito nel formato sbagliato \n");
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
