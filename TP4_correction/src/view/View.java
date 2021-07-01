package view;

import controller.Controller;
import events.CouleurObservateur;
import events.NouvelleValeurCouleurEvenement;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class View implements CouleurObservateur
{
	private Controller controlleur;
	
	@FXML
	private Slider sliderR;
	
	@FXML
	private TextField textfieldR;
	
	@FXML
	private Slider sliderV;
	
	@FXML
	private TextField textfieldV;
	
	@FXML
	private Slider sliderB;
	
	@FXML
	private TextField textfieldB;
	
	@FXML
	private TextField textfieldHexa;
	
	@FXML
	private Pane couleur;
	
	public View(Controller controlleur)
	{
		this.controlleur = controlleur;
		controlleur.ajouterUnObservateur(this);
	}
	
	@FXML
	public void initialize()
	{
		//On initialise la valeur de rouge à 0
		sliderR.setValue(0);
		textfieldR.setText("0");
		
		//On configure l'action à effectuer quand l'utilisateur 
		//manipule le Slider correspondant à la valeur de rouge
		sliderR.valueProperty().addListener(new ChangeListener<Number>() 
		{
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) 
			{
				controlleur.ValeurRougeModifiee(newValue.intValue());
			}
		});
		
		//On configure l'action à effectuer quand l'utilisateur 
		//écrit dans le TextField correspondant à la valeur de rouge
		textfieldR.textProperty().addListener(new ChangeListener<String>()
		{
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				try
				{
					int valeurRouge = Integer.parseInt(newValue);
					
					if(valeurRouge > 255 || valeurRouge < 0)
					{
						System.out.println("Vous devez entrer un entier compris entre 0 et 255.");
						return;
					}
					
					controlleur.ValeurRougeModifiee(valeurRouge);
				}
				catch (Exception e)
				{
					System.out.println("Vous devez entrer un entier.");
					return;
				}
			}
		});
		
		//On initialise la valeur de vert à 0
		sliderV.setValue(0);
		textfieldV.setText("0");
		
		//On configure l'action à effectuer quand l'utilisateur 
		//manipule le Slider correspondant à la valeur de vert
		sliderV.valueProperty().addListener(new ChangeListener<Number>() 
		{
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) 
			{
				controlleur.ValeurVertModifiee(newValue.intValue());
			}
		});
		
		//On configure l'action à effectuer quand l'utilisateur 
		//écrit dans le TextField correspondant à la valeur de vert
		textfieldV.textProperty().addListener(new ChangeListener<String>()
		{
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				try
				{
					int valeurVert = Integer.parseInt(newValue);
					
					if(valeurVert > 255 || valeurVert < 0)
					{
						System.out.println("Vous devez entrer un entier compris entre 0 et 255.");
						return;
					}
					
					controlleur.ValeurVertModifiee(valeurVert);
				}
				catch (Exception e)
				{
					System.out.println("Vous devez entrer un entier.");
					return;
				}
			}
		});
		
		//On initialise la valeur de bleu à 0
		sliderB.setValue(0);
		textfieldB.setText("0");
		
		//On configure l'action à effectuer quand l'utilisateur 
		//manipule le Slider correspondant à la valeur de bleu    	
		sliderB.valueProperty().addListener(new ChangeListener<Number>() 
		{
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) 
			{
				controlleur.ValeurBleuModifiee(newValue.intValue());
			}
		});
		
		//On configure l'action à effectuer quand l'utilisateur 
		//écrit dans le TextField correspondant à la valeur de bleu
		textfieldB.textProperty().addListener(new ChangeListener<String>()
		{
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				try
				{
					int valeurBleu = Integer.parseInt(newValue);
					
					if(valeurBleu > 255 || valeurBleu < 0)
					{
						System.out.println("Vous devez entrer un entier compris entre 0 et 255.");
						return;
					}
					
					controlleur.ValeurBleuModifiee(valeurBleu);
				}
				catch (Exception e)
				{
					System.out.println("Vous devez entrer un entier.");
					return;
				}
			}
		});
		
		//On initialise la valeur hexadecimale
		textfieldHexa.setText("#000000");
		
		//On configure l'action à effectuer quand l'utilisateur
		//écrit dans le TextField correspondant à la valeur hexadécimale
		textfieldHexa.textProperty().addListener(new ChangeListener<String>()
		{
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				try 
				{
					java.awt.Color couleur = java.awt.Color.decode(("#"+newValue));
					int valeurRouge = couleur.getRed();
					int valeurVert = couleur.getGreen();
					int valeurBleu = couleur.getBlue();
					
					if((valeurRouge > 255 || valeurRouge < 0) && (valeurVert > 255 || valeurVert < 0) && (valeurBleu > 255 || valeurBleu < 0))
					{
						System.out.println("Vous devez entrer un entier compris entre 0 et 255.");
						return;
					}
					
					controlleur.CouleurModifiee(valeurRouge, valeurVert, valeurBleu);
				}
				catch (Exception e)
				{
					System.out.println("Vous devez entrer un entier.");
					return;
				}
			}
		});
	}
	
	@Override
	public void NouvelleValeurCouleur(NouvelleValeurCouleurEvenement evenement)
	{
		sliderR.setValue(evenement.getValeurRouge());
		textfieldR.setText("" + evenement.getValeurRouge());
		
		sliderV.setValue(evenement.getValeurVert());
		textfieldV.setText("" + evenement.getValeurVert());
		
		sliderB.setValue(evenement.getValeurBleu());
		textfieldB.setText("" + evenement.getValeurBleu());
		
		textfieldHexa.setText("" + evenement.getValeurHexadecimale());
		
		couleur.setStyle("-fx-background-color:#" + evenement.getValeurHexadecimale() + ";");
	}
}