package view;

import event.PercentageValueChangedEvent;
import event.PercentageValueListener;
import javafx.scene.control.Label;

public class LabelView extends Label implements ViewInterface,PercentageValueListener
/** TODO 6. Faites en sorte que les diff�rentes vues aient
 * chacune une m�thode permettant de la mettre � jour.
 */
/** TODO 7.Faites en sorte que les diff�rentes vues re�oivent
 * un �v�nement de type PercentageValueChangedEvent si l'�tat
 * interne du mod�le est modifi�.
 */
{	
	public void update(double value) {
		setText(value + "%");
	}

	@Override
	public void percentageValueChanged(PercentageValueChangedEvent event) {
		update(Math.round(event.getNewValue() * 100));
	}
}