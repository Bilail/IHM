package model;


import java.util.ArrayList;

import com.sun.prism.paint.Color;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Model 
{
	private Color color ;
	
	public Model()
	{
		color = new Color(0, 0, 0, 0);
	}
	
	

	public Color getColor()
	{
		return color;
	}
	
	public void setColor(float r, float g, float b,float t)
	{
		color = new Color(r, g, b, t);
	}
	


	

}