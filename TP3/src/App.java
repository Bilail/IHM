import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import controller.Controller;
import model.Model;
import view.ConsoleView;
import view.LabelView;
import view.PieChartView;
import view.SliderView;

public class App extends VBox
{
	Model model;
	
	Controller controller;
	
	LabelView labelView;
	PieChartView pieChartView;
	SliderView sliderView;
	ConsoleView consoleView;
	
	public App()
	{
		//On crée le modèle
		model = new Model(0.0f);
		
		//On crée le controlleur
		controller = new Controller(model);
		
		//On crée les vues
		/** TODO 3. Ajoutez les quatre vues ConsolView, LabelView,
		 * PieChartView, SliderView à la classe principale (App.java).
		 */
		//e.g. labelView = new LabelView();
		consoleView = new ConsoleView();
		labelView = new LabelView();
		pieChartView = new PieChartView(controller);
		sliderView = new SliderView(controller);
		
			
		//On connecte les vues au modèle
		/** TODO 7.Faites en sorte que les différentes vues reçoivent
		 * un événement de type PercentageValueChangedEvent si l'état
		 * interne du modèle est modifié.
		 */
		//e.g. controller.addPercentageValueListener(labelView);
		
		controller.addPercentageValueListener(consoleView);
		controller.addPercentageValueListener(labelView);
		controller.addPercentageValueListener(pieChartView);
		controller.addPercentageValueListener(sliderView);
		
		//On initialise l'interface utilisateur
		initialiserUI();
		
		//On rend la fenêtre visible
		setVisible(true);
	}
	
	/**
	 * Initialise l'interface utilisateur (UI) de l'application.
	 */
	private void initialiserUI()
	{
		Label label = new Label("Percentage: ");
		labelView.setDisable(true);
		
		//On crée un sous-Pane pour le label et sa valeur (labelView)
		HBox northPanel = new HBox();
		northPanel.getChildren().addAll(label,labelView);
		
		//On définit l'espacement entre les différents éléments du Pane
		this.setSpacing(30);
		VBox.setMargin(this, new Insets(15, 15, 15, 15));
		this.setAlignment(Pos.CENTER);
		
		//On ajoute tous les éléments au Pane
		this.getChildren().addAll(northPanel,pieChartView,sliderView);
	}
}
