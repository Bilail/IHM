package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import controller.Controller;
import event.PercentageValueChangedEvent;
import event.PercentageValueListener;

public class SliderView extends Slider implements ViewInterface,PercentageValueListener
/** TODO 6. Faites en sorte que les diff�rentes vues aient
 * chacune une m�thode permettant de la mettre � jour.
 */
/** TODO 7.Faites en sorte que les diff�rentes vues re�oivent
 * un �v�nement de type PercentageValueChangedEvent si l'�tat
 * interne du mod�le est modifi�.
 */
{
	@SuppressWarnings("unused")
	private final Controller controller;
	
	public SliderView(Controller controller)
	{
		this.controller = controller;
		
		//On personnalise le Slider
		setMin(0);
		setMax(100);
		this.setMinorTickCount(5);
		this.setMajorTickUnit(10);
		this.setShowTickLabels(true);
		this.setShowTickMarks(true);
		this.setBlockIncrement(10);
		this.setSnapToTicks(true);
		
		valueProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
			{
				/** TODO 5. Impl�mentez SliderView pour qu'elle mette
				 *  � jour le mod�le si l'utilisateur la manipule
				 *  (attention, tout doit passer par le controlleur).
				 */
				controller.setValue((double) newValue/100);
			}
		});
	}
	public void update(double value) {
		setValue(value);
	}
	@Override
	public void percentageValueChanged(PercentageValueChangedEvent event) {
		// TODO Auto-generated method stub
		
	}
}
