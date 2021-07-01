package events;

public interface CouleurObservateur 
{
	/**
	 * Informe le CouleurObservateur que l'état du modèle a changé.
	 * @param evenement L'événement contenant le nouvel état du modèle
	 */
	public void NouvelleValeurCouleur(NouvelleValeurCouleurEvenement evenement);
}
