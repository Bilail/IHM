package app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TemperatureConverter extends Application 
{
	private Button buttonReset ;
	private Button buttonClose;
	private Label labelC ;
	private Label labelF ;
	private TextField textFieldC ;
	private TextField textFieldF ;
	private EventHandler<KeyEvent> textFieldCListener;
	private EventHandler<KeyEvent> textFieldFListener;
	private EventHandler<ActionEvent> buttonResetListener;
	private EventHandler<ActionEvent> buttonCloseListener;
	private TextFormatter<Object> textFormatterC;
	private TextFormatter<Object> textFormatterF;
	
	@Override
	public void start(Stage stage) throws Exception
	{
		/*
		 * APPLICATION : Il s'agit de notre application JavaFX
		 * STAGE : Il s'agit du contenant de haut niveau de l'application
		 * SCENE : C'est l'objet qui contient tous les éléments visuels
		 */
		
		//On définit un Pane "root" qui contiendra tous les autres éléments
		FlowPane root = new FlowPane();
        
		//On crée une scene qui contient le Pane "root" comme contenant principal
		Scene scene = new Scene(root); 
		
		//On définit la hauteur du stage (en paramètre)
		stage.setHeight(200);
		stage.setMaxHeight(300);
		stage.setMinHeight(155);
		//On définit la largeur du stage (en paramètre)
		stage.setWidth(400);
		stage.setMaxWidth(450);
		stage.setMinWidth(180);        
		
		//On initialise les TextFormatters qui gèrent les entrées de nos TextFields
		initTextFormatters();
		
		//On initialise les Listeners des éléments qui composent notre interface utilisateur
		initListeners();
		
		//On initialise l'interface utilisateur (UI) de l'application
		//(GUI pour Graphic User Interface)
		initGUI(root);
		
		//On donne un titre au stage
		stage.setTitle("Temperature Converter");
		
		//On définit la scene ainsi créée comme étant celle du stage
		stage.setScene(scene);
		
		//On affiche le stage
		stage.show();
	}
	
	/**
	 * Cette méthode permet l'initialisation des TextFormatters.
	 * Ces TextFormatters gèrent les entrées de nos TextFields.
	 */
	public void initTextFormatters()
	{
		/*
		* Le TextFormatter de textFieldC :
		* Ce TextFormatter accepte un nouveau caractère seulement si le texte entré
		* reste un nombre valide (positif or negatif). Il accepte également les
		* nombres scientifiques de la forme xxEx où E représente une puissance de 10.
		*/
		textFormatterC = new TextFormatter<>(character -> 
		{
			/*
			 * TODO: 8.(Pour aller plus loin ...) Associez un TextFormatter à textFieldC
			 * pour qu'il n'accepte que des entrées valides (e.g. 23, 23.345, -21, 3E -02).
			 */	
			 
			 return character;
		});

		/*
		* Le TextFormatter de textFieldF :
		* Ce TextFormatter accepte un nouveau caractère seulement si le texte entré
		* reste un nombre valide (positif or negatif). Il accepte également les
		* nombres scientifiques de la forme xxEx où E représente une puissance de 10.
		*/
		textFormatterF = new TextFormatter<>(character -> 
		{
			/*
			 * TODO: 8.(Pour aller plus loin ...) Associez un TextFormatter à textFieldF
			 * pour qu'il n'accepte que des entrées valides (e.g. 23, 23.345, -21, 3E -02).
			 */	
			 
			 return character;
		});
	}

	/**
	 * Cette méthode permet l'initialisation des Listeners des éléments de l'UI.
	 */
	public void initListeners()
	{
		/*
		 * Le Listener de textFieldC : 
		 * Lorsque l'utilisateur appuie sur la touche "ENTRÉE", ce Listener
		 * convertit la valeur en Celsius entrée dans textFieldC en Fahrenheit
		 * (à condition que le focus soit sur testFieldC)
		 */
		textFieldCListener = new EventHandler<KeyEvent>() 
		{
			@Override
			public void handle(KeyEvent e)
			{
				//Si l'utilisateur a appuyé sur la touche "ENTRÉE"
				if (e.getCode().equals(KeyCode.ENTER)) 
				{
					//On récupère le texte entré dans textFieldC
					String value = textFieldC.getText();
					
					try 
					{
						//On transforme ce texte en float
						float valC = new Float(value);
						//On calcule l'équivalence de cette valeur en Fahrenheit
						float valF = valC * 1.8f + 32;
						//On affiche la valeur en Fahrenheit dans textFieldF
						textFieldF.setText(Float.toString(valF));
					}
					//Si le code précédent retourne une erreur
					catch (Exception exception) 
					{
						//On vide textFieldF
						textFieldF.setText("");
						//On vide textFieldC
						textFieldC.setText("");
					}
				}
			}
		};

		/*
		 * Le Listener de textFieldF : 
		 * Lorsque l'utilisateur appuie sur la touche "ENTRÉE", ce Listener
		 * convertit la valeur en Fahrenheit entrée dans textFieldF en Celsius
		 * (à condition que le focus soit sur testFieldF)
		 */
		textFieldFListener = new EventHandler<KeyEvent>() 
		{
			@Override
			public void handle(KeyEvent e) 
			{
				/*
				 * TODO: 5. Implémentez le textFieldFListener pour qu'il réalise les actions suivantes si
				 * l'utilisateur appuie sur la touche ENTRÉE, alors que le focus est sur textFieldF :
				 * 
				 * - lire la valeur indiquée dans le champs de texte correspondant à la valeur en Fahrenheit;
				 * - transformer cette valeur en float (attention à la gestion des exceptions !);
				 * - convertir cette valeur en Celsius;
				 * - écrire cette nouvelle valeur dans le champs de texte correspondant à la valeur en Celsius.
				 */
			}     		
		};

		/*
		 * Le Listener du bouton "Reset" :
		 * Si l'utilisateur clique sur le bouton "Reset", ce Listener vide les
		 * differents TextFields.
		 */
		buttonResetListener = new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event) 
			{
				/*
				 * TODO: 7. Implémentez le buttonResetListener pour qu'il vide les deux champs de texte.
				 */	
			}
		};

		/*
		 * Le Listener du bouton "Close" :
		 * Si l'utilisateur clique sur le bouton "Close", ce Listener ferme l'application.
		 */
		buttonCloseListener = new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) 
			{
				//On quitte l'application
				Platform.exit();
			}
		};
	}

	/**
	 * Cette méthode permet l'initialisation des éléments graphiques.
	 * @param root Le Pane principal de la scene
	 */
	public void initGUI(Pane root)
	{
		/*
		 * TODO: 2. Complétez la fonction initGUI() pour qu'elle agence correctement les différents
		 * éléments graphiques (la disposition finale doit être proche de celle de la photo).
		 * Utilisez la classe FlowPane pour le contenant principal puis d'autres Panes de votre choix
		 * pour les autres éléments.
		 */
		root.setStyle("-fx-border-color: oranged; -fx-border-width: 3px;");
		
		//On crée le Pane de la partie Celsius
		VBox paneC = new VBox();
		paneC.setPadding(new Insets(10, 10, 10, 10));
		paneC.setStyle("-fx-border-color: DARKORCHID; -fx-border-width: 3px");
		paneC.setMinHeight(75);
		paneC.setMinWidth(175);
		root.getChildren().add(paneC);
		
		//On crée le Pane de la partie Fahrenheit
		VBox paneF = new VBox();
		paneF.setPadding(new Insets(10, 10, 10, 10));
		paneF.setStyle("-fx-border-color: yellow; -fx-border-width: 3px");
		paneF.setMinHeight(75);
		paneF.setMinWidth(175);
		root.getChildren().add(paneF);
		
		
		//On crée le Pane des boutons 
		HBox paneButtons = new HBox();
		paneButtons.setPadding(new Insets(10, 10, 10, 10));
		paneButtons.setSpacing(10);
		paneButtons.setStyle("-fx-border-color: lightfreen; -fx-border-width: 3px");
		paneButtons.setMinHeight(54);
		paneButtons.setMinWidth(175);
		paneButtons.setAlignment(Pos.CENTER_RIGHT);
		root.getChildren().add(paneButtons);
		
		/*
		 * TODO: 3. Assurez-vous que les éléments graphiques sont correctement alignés et que leurs
		 * positions sont cohérentes avec la photo suivante lorsque vous changez la taille de la fenêtre.
		 */
		
		/*
		 * TODO: 4. Associez le textFieldCListener au champs de texte correspondant à la valeur en Celsius.
		 */
		labelC = new Label("Celsius");
		labelC.setPadding(new Insets(10, 10, 10, 10));
		labelC.setStyle("-fx-border-color: DARKORCHID; -fx-border-width: 3px;");
		paneC.getChildren().add(labelC);
		
		textFieldC = new TextField("");
		textFieldC.setStyle("-fx-border-color: lightgreen; -fx-border-width: 3px;");
		paneC.getChildren().add(textFieldC);
		textFieldC.setOnKeyPressed(textFieldCListener);
		textFieldC.setTextFormatter(textFormatterC);
		/*
		 * TODO: 5. Associez le textFieldFListener au champs de texte correspondant à la valeur en Fahrenheit.
		 */
		//On cree le label de la partie fahrenheit
		labelF = new Label("Fahrenheit");
		labelF.setPadding(new Insets(10, 10, 10, 10));
		labelF.setStyle("-fx-border-color: DARKORCHID; -fx-border-width: 3px;");
		paneF.getChildren().add(labelF);
		
		textFieldF = new TextField("");
		textFieldF.setStyle("-fx-border-color: lightgreen; -fx-border-width: 3px;");
		paneF.getChildren().add(textFieldF);
		textFieldF.setOnKeyPressed(textFieldFListener);
		textFieldF.setTextFormatter(textFormatterF);
		/*
		 * TODO: 6. Le buttonCloseListener quitte l'application . Associez-le au bouton Close.
		 */
		
		/*
		 * TODO: 7. Associez le buttonResetListener au bouton Reset.
		 */
		
		/*
		 * TODO: 8.(Pour aller plus loin ...) Associez les TextFormatters à textFieldF et textFieldC.
		 */	
	}

	//La fonction principale ne doit pas être modifiée !
	public static void main(String[] args) 
	{
		//On lance l'application
		launch(args);
	}
}
