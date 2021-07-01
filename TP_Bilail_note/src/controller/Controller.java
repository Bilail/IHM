package controller;


import Application.App;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import model.Model;
import Application.App;

public class Controller
{
	private final Model model;
	
	public Controller(Model model)
	{
		this.model = model;
	}
	
	public com.sun.prism.paint.Color getColor()
	{
		return model.getColor();
	}
	

	public void setColor(float r, float g, float b,float t)
	{
		model.setColor(r, g, b, t);
	}

	 StringConverter<Number> sc = new NumberStringConverter();
       textFieldR.textProperty().bindBidirectional(sliderRED.valueProperty(), sc);
       textFieldG.textProperty().bindBidirectional(sliderGREEN.valueProperty(), sc);
       textFieldB.textProperty().bindBidirectional(sliderBLUE.valueProperty(), sc);
       
  	 ChangeListener<Number> listener = new ChangeListener<Number>() {
         @Override
         public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
             Color newColor = new Color(sliderR.getValue()/255, sliderG.getValue()/255, sliderB.getValue()/255, 1);
             paneColor.setFill(newColor);
             //hBox.setBackground(new Background(new BackgroundFill(newColor, null, null)));
         }
     };
     sliderRED.valueProperty().addListener(listener);
     sliderGREEN.valueProperty().addListener(listener);
     sliderBLUE.valueProperty().addListener(listener);
}
}