import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.View;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        //On crée le view
        View controller = new View();

        try
        {
            //On prépare le fichier FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));


            //On charge le fichier FXML, il appellera la méthode *initialize()* de la vue
            Parent root = loader.load();

            //On crée la scène
            Scene scene = new Scene(root);

            //On définit cette scène comme étant la scène de notre première fenêtre
            primaryStage.setScene(scene);

            //On rend cette fenêtre visible
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
