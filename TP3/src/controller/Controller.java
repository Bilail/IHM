package controller;

import event.PercentageValueListener;
import model.Model;

public class Controller implements ControllerInterface
{
	private final Model model;
	
	public Controller(Model model)
	{
		this.model = model;
	}
	
	@Override
	public double getValue()
	{
		/**TODO 4. Complétez la classe Controller pour qu'elle fasse
		 * le lien entre le modèle et les vues.
		 */
		double v = model.getValue();
		return v;
	}
	
	@Override
	public void setValue(double value)
	{
		/**TODO 4. Complétez la classe Controller pour qu'elle fasse
		 * le lien entre le modèle et les vues.
		 */
		model.setValue(value);
	}

	@Override
	public void addPercentageValueListener(PercentageValueListener percentageValueListener)
	{
		/**TODO 4. Complétez la classe Controller pour qu'elle fasse
		 * le lien entre le modèle et les vues.
		 */
		
		model.addPercentageValueListener(percentageValueListener);
	}
	
	@Override
	public void removePercentageValueListener(PercentageValueListener percentageValueListener)
	{
		/**TODO 4. Complétez la classe Controller pour qu'elle fasse
		 * le lien entre le modèle et les vues.
		 */
		model.removePercentageValueListener(percentageValueListener);
	}
	
	@Override
	public void notifyValueChanged(double value)
	{
		/**TODO 4. Complétez la classe Controller pour qu'elle fasse
		 * le lien entre le modèle et les vues.
		 */
		model.setValue(value);
	}
}