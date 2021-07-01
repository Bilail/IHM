package controller;


import java.util.ArrayList;

import model.Model;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;


public class Controller
{

    private Model model;

    public Controller()
    {
        model = new Model();
    }

    public void addEllipse(double x, double y, Color color)
    {
        model.drawEllipse(x,y,color);
    }

    public void addRectangle(double x, double y, Color color)
    {
        model.drawRectangle(x,y,color);
    }

    public void addLine(double x1, double y1, double x2, double y2, Color color)
    {
        model.drawLine(x1,y1,x2,y2,color);
    }

    public ArrayList<Shape> ObtenirFormes()
    {
        return model.getFormes();
    }

    public void setColor(Shape f, Color c) {
        model.setColor(f, c);
    }

    public void Selected(Shape s) {
        model.Selected(s);
    }
    public void notSelected(Shape s) {
        model.notSelected(s);
    }

    public void Drag(Shape s, double mouseX, double mouseY) {
        model.Drag(s, mouseX, mouseY);
    }

    public void delete(Shape s) {
        model.delete(s);
    }

    public void clone(Shape s) {
        model.clone(s);
    }



}
