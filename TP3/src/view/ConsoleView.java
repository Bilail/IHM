package view;

import event.PercentageValueChangedEvent;
import event.PercentageValueListener;

public class ConsoleView implements ViewInterface,PercentageValueListener
/** TODO 6. Faites en sorte que les différentes vues aient
 * chacune une méthode permettant de la mettre à jour.
 */
/** TODO 7.Faites en sorte que les différentes vues reçoivent
 * un événement de type PercentageValueChangedEvent si l'état
 * interne du modèle est modifié.
 */
{

	@Override
	public void percentageValueChanged(PercentageValueChangedEvent event) {
		update(Math.round(event.getNewValue() * 100));
	}

	@Override
	public void update(double value) {
		System.out.println("La nouvelle valeur du pourcentage est : " + value + "%.");		
	}
	
}
