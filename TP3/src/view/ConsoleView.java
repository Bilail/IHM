package view;

import event.PercentageValueChangedEvent;
import event.PercentageValueListener;

public class ConsoleView implements ViewInterface,PercentageValueListener
/** TODO 6. Faites en sorte que les diff�rentes vues aient
 * chacune une m�thode permettant de la mettre � jour.
 */
/** TODO 7.Faites en sorte que les diff�rentes vues re�oivent
 * un �v�nement de type PercentageValueChangedEvent si l'�tat
 * interne du mod�le est modifi�.
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
