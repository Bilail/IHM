import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		VBox root = new VBox();
		App app = new App();
		root.getChildren().add(app);
		
		primaryStage.setTitle("Model - View - Controller");
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.setResizable(false);
		primaryStage.show();
    }
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
