package view;

import javafx.scene.control.Label;
import event.PercentageValueChangedEvent;
import event.PercentageValueListener;

public class LabelView extends Label implements ViewInterface,PercentageValueListener
{	
	@Override
	public void update(double value)
	{
		setText(value + "%");
	}
	
	@Override
	public void percentageValueChanged(PercentageValueChangedEvent event)
	{
		update(Math.round(event.getNewValue() * 100));
	}
}