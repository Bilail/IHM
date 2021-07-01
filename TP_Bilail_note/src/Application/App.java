package Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import controller.Controller;
import model.Model;


import view.SliderView;

public class App extends HBox
{
	//Model model;
	
	//Controller controller;
	TextField textFieldR;
	TextField textFieldG;
	TextField textFieldB;
	TextField Hexa;
	Slider sliderRED;
	Slider sliderGREEN;
	Slider sliderBLUE;
	
	public App()
	{
		//Model m = new Model();
		//Controller c = new Controller(m);
		

	
		Slider sliderRED = new Slider(0, 255, 50);
		
	
		Slider sliderGREEN = new Slider(0, 255, 50);
	
		Slider sliderBLUE = new Slider(0, 255, 50);
		
		
		VBox Color = new VBox();
		
		HBox paneBLUE = new HBox();
		paneBLUE.setPadding(new Insets(10, 10, 10, 10));
		textFieldB = new TextField("");		
		paneBLUE.getChildren().addAll(sliderBLUE, textFieldB);
		
		HBox paneRED = new HBox();
		paneRED.setPadding(new Insets(10, 10, 10, 10));		
		textFieldR = new TextField("");
		paneRED.getChildren().addAll(sliderRED, textFieldR);
		//textFieldR.setOnKeyPressed(textFieldFListener);
		//textFieldR.setTextFormatter(textFormatterR);
		
		HBox paneGREEN = new HBox();
		paneGREEN.setPadding(new Insets(10, 10, 10, 10));
		textFieldG = new TextField("");
		paneGREEN.getChildren().addAll(sliderGREEN,textFieldG);
		
		Color.getChildren().addAll(paneBLUE,paneRED,paneGREEN);
		this.getChildren().add(Color);
		
		VBox Color2 = new VBox();
		Hexa = new TextField("");
		Rectangle paneColor = new Rectangle(0, 0, 100, 100);
	    paneColor.setFill(new Color(0,0,1,1));

		
		Color2.getChildren().addAll(Hexa,paneColor);
		
		this.getChildren().add(Color2);
		
		
	/*
		controller.addPercentageValueListener(labelViewb);
		controller.addPercentageValueListener(sliderViewb);
		
		controller.addPercentageValueListener(labelViewg);
		controller.addPercentageValueListener(sliderViewg);
		
		controller.addPercentageValueListener(labelViewr);
		controller.addPercentageValueListener(sliderViewr);

	*/	
		
	
		
		//On rend la fenêtre visible
		setVisible(true);
	}

	 void maj(App A) {
	 StringConverter<Number> value = new NumberStringConverter();
     textFieldR.textProperty().bindBidirectional(sliderRED.valueProperty(), value);
     textFieldG.textProperty().bindBidirectional(sliderGREEN.valueProperty(), value);
     textFieldB.textProperty().bindBidirectional(sliderBLUE.valueProperty(), value);
     
     
     
     
     
     
     ChangeListener<Number> listener = new ChangeListener<Number>() {
         @Override
         public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
             Color newColor = new Color(sliderR.getValue()/255, sliderG.getValue()/255, sliderB.getValue()/255, 1);
             paneColor.setFill(newColor);
             //hBox.setBackground(new Background(new BackgroundFill(newColor, null, null)));
         }
     };
     
     
     
     
         
    sliderR.valueProperty().addListener(listener);
    sliderG.valueProperty().addListener(listener);
    sliderB.valueProperty().addListener(listener);
    }
	
}
