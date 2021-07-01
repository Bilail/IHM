package events;

import javafx.event.Event;
import javafx.event.EventType;

@SuppressWarnings("serial")
public class NouvelleValeurRougeEvenement extends Event
{
	private int valeurRouge;
	
	public final static EventType<NouvelleValeurRougeEvenement> NOUVELLE_VALEUR_ROUGE = new EventType<>("NOUVELLE_VALEUR_ROUGE");
	
	public NouvelleValeurRougeEvenement(Object source, int nouvelleValeurRouge)
	{
		super(NOUVELLE_VALEUR_ROUGE);
		this.valeurRouge = nouvelleValeurRouge;
	}
	
	/**
	 * Donne accès à la valeur de rouge transmise par l'événement.
	 * @return La valeur de rouge
	 */
	public int getValeurRouge()
	{
		return valeurRouge;
	}
}