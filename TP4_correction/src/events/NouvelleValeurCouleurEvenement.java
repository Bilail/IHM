package events;

import javafx.event.Event;
import javafx.event.EventType;

@SuppressWarnings("serial")
public class NouvelleValeurCouleurEvenement extends Event
{
	private int valeurRouge;
	private int valeurVert;
	private int valeurBleu;
	
	public final static EventType<NouvelleValeurCouleurEvenement> NOUVELLE_VALEUR_COULEUR = new EventType<>("NOUVELLE_VALEUR_COULEUR");
	
	public NouvelleValeurCouleurEvenement(Object source, int nouvelleValeurRouge, int nouvelleValeurVert, int nouvelleValeurBleu)
	{
		super(NOUVELLE_VALEUR_COULEUR);
		this.valeurRouge = nouvelleValeurRouge;
		this.valeurVert = nouvelleValeurVert;
		this.valeurBleu = nouvelleValeurBleu;
	}
	
	/**
	 * Donne accès à la valeur de rouge transmise par l'événement.
	 * @return La valeur de rouge
	 */
	public int getValeurRouge()
	{
		return valeurRouge;
	}
	
	/**
	 * Donne accès à la valeur de vert transmise par l'événement.
	 * @return La valeur de vert
	 */
	public int getValeurVert()
	{
		return valeurVert;
	}
	
	/**
	 * Donne accès à la valeur de bleu transmise par l'événement.
	 * @return La valeur de bleu
	 */
	public int getValeurBleu()
	{
		return valeurBleu;
	}
	
	/**
	 * Donne accès à la valeur hexadécimale de la couleur transmise par l'événement.
	 * @return La valeur hexadécimale de la couleur
	 */
	public String getValeurHexadecimale()
	{
		String valeurHexadecimale = String.format("%02x%02x%02x", valeurRouge, valeurVert, valeurBleu);
		return valeurHexadecimale;
	}
}