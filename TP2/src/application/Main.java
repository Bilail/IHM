package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.Parent;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		Parent root = FXMLLoader.load(getClass().getResource("./sample.fxml"));
		primaryStage.setTitle("File selector");
		primaryStage.setScene(new Scene(root,300,400) );
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
