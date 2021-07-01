package events;

import javafx.event.Event;
import javafx.event.EventType;

@SuppressWarnings("serial")
public class NouvelleValeurBleuEvenement extends Event
{
	private int valeurBleu;
	
	public final static EventType<NouvelleValeurBleuEvenement> NOUVELLE_VALEUR_BLEU = new EventType<>("NOUVELLE_VALEUR_BLEU");
	
	public NouvelleValeurBleuEvenement(Object source, int nouvelleValeurBleu)
	{
		super(NOUVELLE_VALEUR_BLEU);
		this.valeurBleu = nouvelleValeurBleu;
	}
	
	/**
	 * Donne accès à la valeur de bleu transmise par l'événement.
	 * @return La valeur de bleu
	 */
	public int getValeurBleu()
	{
		return valeurBleu;
	}
}
