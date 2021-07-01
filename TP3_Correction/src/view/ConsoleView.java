package view;

import event.PercentageValueChangedEvent;
import event.PercentageValueListener;

public class ConsoleView implements ViewInterface,PercentageValueListener
{
	@Override
	public void update(double value)
	{
		System.out.println("La nouvelle valeur du pourcentage est : " + value + "%.");
    }

    @Override
    public void percentageValueChanged(PercentageValueChangedEvent event)
    {
        update(Math.round(event.getNewValue() * 100));
    }

}
