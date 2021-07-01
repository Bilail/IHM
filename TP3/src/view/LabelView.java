package view;

import event.PercentageValueChangedEvent;
import event.PercentageValueListener;
import javafx.scene.control.Label;

public class LabelView extends Label implements ViewInterface,PercentageValueListener
/** TODO 6. Faites en sorte que les différentes vues aient
 * chacune une méthode permettant de la mettre à jour.
 */
/** TODO 7.Faites en sorte que les différentes vues reçoivent
 * un événement de type PercentageValueChangedEvent si l'état
 * interne du modèle est modifié.
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