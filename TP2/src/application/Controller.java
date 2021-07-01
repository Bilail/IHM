package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.io.File;

import application.FileSelector;


public class Controller {
	
	@FXML
	private Button btnCancel ;
	
	@FXML
	private Button btnOpen ;
	
	@FXML
	private ListView listViewFile ;
	
	@FXML
	private ComboBox<String> comboxRep ;
	
	private FileSelector fs = new FileSelector();
	
	private void majComboBox(String path) {
		
		// on met � jours ComboBox
		// on r�cup�re les repertoires � afficher 
		ObservableList<String> itemsComboRep = FXCollections.observableArrayList(fs.getListParentDirectories(path));
				
		//On change les items de la ComboBox
		comboxRep.setItems(itemsComboRep);
		comboxRep.getSelectionModel().selectLast();
	}
	
	private void majListView(String path) {
		//On met � jour ListView
		//Recupere les elements � afficher 
		ObservableList<String> itemsListView = FXCollections.observableArrayList(fs.getContent(path));
		//on change la liste
		listViewFile.setItems(itemsListView);
		
		//Desactiver le Bouton "Open"
    	btnOpen.setDisable(true);
				
	}
	
	@FXML
	public void initialize() {
		// on obtien le chemin vers le repertoire home 
		String path = System.getProperty("user.home");
		
		//On met � jours
		majComboBox(path);
		majListView(path);
		
		
		//Cr�er un EventListener pour la s�lection d'un r�pertoire dans la ComboBox
		comboxRep.setOnAction(event ->  
    	{
    		majListView(comboxRep.getSelectionModel().getSelectedItem());
        });
		
		//Cr�er un EventListener pour la selection d'un item dans la ListView
    	listViewFile.setOnMouseClicked(event ->  
    	{
    		//Activer le Bouton "Open"
    		btnOpen.setDisable(false);
    		
    		if(event.getClickCount() == 2)
    		{
                btnOpen.fire();
            }
        });
		
    	//bouton fermeture
		btnCancel.setOnAction(event -> {
			System.exit(0);
		});
		
		btnOpen.setOnAction(event -> {
			File element = new File(comboxRep.getValue()+listViewFile.getSelectionModel().getSelectedItem());
			//Si l'�l�ment est un fichier
    		if(element.isFile())
    		{
    			
    		}
    		else if(element.isDirectory())
    		{
    			majComboBox(element.getAbsolutePath());
    		}
    		else
    		{
    			
    		}
		});
	};
	
	
}
