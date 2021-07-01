package application;

import controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Model;
import view.View;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		Model modele = new Model();
		Controller controlleur = new Controller(modele);
		View vue = new View(controlleur);
		
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
			loader.setController(vue);
			Parent root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}