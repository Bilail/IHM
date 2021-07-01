package view;

import java.util.ArrayList;

import controller.Controller;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import model.Model;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;
import javafx.scene.Node;




public class View
{
    Controller controller;

    @FXML
    private Button BtnClone;

    @FXML
    private Button BtnDelete;

    @FXML
    private ColorPicker ColorPicker;

    @FXML
    private RadioButton BtnEllipse;

    @FXML
    private RadioButton BtnRectangle;

    @FXML
    private RadioButton BtnLine;

    @FXML
    private RadioButton BtnSelect;

    @FXML
    private AnchorPane dessin;

    @FXML
    private ToggleGroup singletoggle;


    public View()
    {

        controller = new Controller();

    }

    @FXML
    public void initialize()
    {
        //Disable clone and delete button
        BtnClone.setDisable(true);
        BtnDelete.setDisable(true);


        dessin.setOnMouseClicked(event ->
        {
            //Mouse coordinate
            double mouseX = event.getX();
            double mouseY = event.getY();

            ArrayList<Shape> list = controller.ObtenirFormes();

            //Get the color selected in the ColorPicker
            Color color = ColorPicker.getValue();

            if (!BtnSelect.isSelected())
            {
                //Draw an Ellipse if radio button selected
                if (BtnEllipse.isSelected())
                {
                    controller.addEllipse(mouseX,mouseY,color);
                }

                //Draw Rectangle if radio button selected
                if (BtnRectangle.isSelected())
                {
                    controller.addRectangle(mouseX,mouseY,color);
                }

                //Draw a Line if radio button selected
                if (BtnLine.isSelected())
                {
                    controller.addLine(mouseX,mouseY,mouseX+100,mouseY+100,color);
                }
            }

            if (BtnSelect.isSelected())
            {
                for (Shape other : list)
                {
                    //Deselect all other shape
                    controller.notSelected(other);
                }
                for (Shape s : list )
                {
                    if (s.contains(mouseX,mouseY))
                    {
                        //Enable clone and delete button
                        BtnClone.setDisable(false);
                        BtnDelete.setDisable(false);

                        //Define color for cloning
                        controller.setColor(s, color);

                        //We give the user a feedback that the shape is selected
                        controller.Selected(s);

                        //Clone the selected shape on click
                        BtnClone.setOnAction(add ->
                        {
                            controller.clone(s);
                        });
                        //Delete the selected shape on click
                        BtnDelete.setOnAction(supr ->
                        {
                            controller.delete(s);
                        });

                    }
                }
            }
            maj();

        });

        dessin.setOnMouseDragged(event ->
        {
            double mouseX = event.getX();
            double mouseY = event.getY();


            //On récupère la valeur couleur sélectionné
            Color color = ColorPicker.getValue();

            // On regarde sur quelle forme on est
            ArrayList<Shape> list = controller.ObtenirFormes();

            // Si le bouton select est sélectionner
            if(BtnSelect.isSelected())
            {
                for (Shape s : list)
                {
                    //On regarde quelle forme est sélectionné
                    if (s.contains(mouseX,mouseY))
                    {

                        // On redéfini le couleur choisi
                        controller.setColor(s, color);

                        // on définie le contour accentue
                        controller.Selected(s);

                        //on bouge la forme
                        controller.Drag(s, mouseX, mouseY);

                    }
                }

            }
            maj();

        });

    }


    public void maj()
    {
        ArrayList<Shape> list = controller.ObtenirFormes();
        dessin.getChildren().clear();
        dessin.getChildren().addAll(list);
    }

}

