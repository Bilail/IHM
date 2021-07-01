package event;

import java.util.EventListener;

public interface PercentageValueListener extends EventListener
{
	/**
	 * Réagit à un changement de la valeur du pourcentage dans le modèle.
	 * @param event l'évenement correspondant à ce changement
	 */
	public void percentageValueChanged(PercentageValueChangedEvent event);
}