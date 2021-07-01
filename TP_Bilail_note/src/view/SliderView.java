package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import controller.Controller;
import event.PercentageValueChangedEvent;
import event.PercentageValueListener;

public class SliderView extends Slider 
{
	@SuppressWarnings("unused")
	private final Controller controller;
	
	public SliderView(Controller controller)
	{
		this.controller = controller;
		
		
		
		valueProperty().addListener(new ChangeListener<Number>()
		{
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
			{
				controller.notifyValueChanged(getValue() / 100F);
			}
		});
	}
	
	@Override
	public void update(double value)
	{
		this.setValue(value);
	}
	
	@Override
	public void percentageValueChanged(PercentageValueChangedEvent event)
	{
		update(Math.round(event.getNewValue() * 100));
	}
}
