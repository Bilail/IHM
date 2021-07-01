package model;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Model
{
    private ArrayList<Shape> Formes;

    public Model()
    {
        Formes = new ArrayList<Shape>();
    }

    public void drawEllipse(double x, double y, Color color)
    {
        Ellipse ellipse = new Ellipse(50,50);
        ellipse.setCenterX(x);
        ellipse.setCenterY(y);
        ellipse.setFill(color);
        ellipse.setStrokeWidth(1);
        ellipse.setStroke(Color.BLACK);
        Formes.add(ellipse);
    }

    public void drawRectangle(double x, double y, Color color) {
        Rectangle rectangle = new Rectangle(x,y,100,150);
        rectangle.setFill(color);
        rectangle.setStrokeWidth(1);
        rectangle.setStroke(Color.BLACK);
        Formes.add(rectangle);
    }

    public void drawLine(double x1, double y1, double x2, double y2, Color color) {
        Line line = new Line(x1,y1,x2,y2);
        line.setFill(color);
        line.setStrokeWidth(10);
        line.setStroke(color);
        Formes.add(line);
    }


    public void setColor(Shape s, Color c){
        int index = Formes.indexOf(s);
        s.setFill(c);
        Formes.set(index, s);
    }

    public void Selected(Shape s)
    {
        for (Shape other : Formes)
        {
            notSelected(other);
        }
        int index = Formes.indexOf(s);
        s.setStroke(Color.YELLOW);
        s.setStrokeWidth(5);
        Formes.set(index,s);
    }

    public void notSelected(Shape s)
    {
        int index = Formes.indexOf(s);
        s.setStrokeWidth(1);
        s.setStroke(Color.BLACK);
        Formes.set(index, s);
    }

    public void Drag(Shape s, double mousex, double mousey)
    {
        int index = Formes.indexOf(s);

        if(s instanceof Rectangle) {
            ((Rectangle) s).setX(mousex);
            ((Rectangle) s).setY(mousey);
        }

        if(s instanceof Ellipse) {
            ((Ellipse) s).setCenterX(mousex);
            ((Ellipse) s).setCenterY(mousey);
        }

        if(s instanceof Line) {
            ((Line) s).setStartX(mousex);
            ((Line) s).setStartY(mousey);

        }

        Formes.set(index, s);
    }

    public void delete(Shape s)
    {
        Formes.remove(s);
    }

    public void clone(Shape s)
    {

        if(s instanceof Rectangle)
        {
            double xclone = ((Rectangle) s).getX()-30;
            double yclone = ((Rectangle) s).getY()-30;
            drawRectangle(xclone, yclone, (Color) s.getFill());
        }

        if(s instanceof Ellipse)
        {
            double xclone = ((Ellipse) s).getCenterX()-30;
            double yclone = ((Ellipse) s).getCenterY()-30;
            drawEllipse(xclone,yclone,  (Color) s.getFill());
        }

        if(s instanceof Line)
        {
            double xclone = ((Line) s).getStartX()-30;
            double yclone = ((Line) s).getStartY()-30;
            drawLine(xclone,yclone,xclone+100,yclone+100,(Color) s.getFill());

        }

    }

    public ArrayList<Shape> getFormes()
    {
        return Formes;
    }
}
