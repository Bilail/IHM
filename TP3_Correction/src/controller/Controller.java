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
		return model.getValue();
	}
	
	@Override
	public void setValue(double value)
	{
		model.setValue(value);
	}

	@Override
	public void addPercentageValueListener(PercentageValueListener percentageValueListener)
	{
		model.addPercentageValueListener(percentageValueListener);
	}
	
	@Override
	public void removePercentageValueListener(PercentageValueListener percentageValueListener)
	{
		model.removePercentageValueListener(percentageValueListener);
	}
	
	@Override
	public void notifyValueChanged(double value)
	{
		model.setValue(value);
	}
}