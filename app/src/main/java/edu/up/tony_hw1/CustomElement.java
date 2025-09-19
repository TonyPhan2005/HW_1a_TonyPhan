package edu.up.tony_hw1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import java.util.ArrayList;
import java.util.List;

public class CustomElement {

    public enum HouseType
    {
        BASE, ROOF, SUN, DOOR, WINDOW, CLOUD
    }

    public static class Element
    {
        private HouseType type;
        private Paint paint;
        // private int color;
        // private Float x, y, size;

        public Element(HouseType type, int color)
        {
            this.type = type;
            this.paint = new Paint();
            this.paint.setColor(color);
        }

        public HouseType getType()
        {
            return type;
        }

        public Paint getPaint()
        {
            return paint;
        }

        public void setColor(int color)
        {
            paint.setColor(color);
        }

        public void draw(Canvas canvas)
        {
            switch (type)
            {
                // BASE ROOF SUN DOOR WINDOW CLOUD
                case BASE:
                    canvas.drawRect(700, 750, 1500, 1625, paint);
                    break;

                case ROOF:
                    Path triangle = new Path();
                    triangle.moveTo(1125,400);
                    triangle.lineTo(700,750);
                    triangle.lineTo(1500,750);
                    triangle.close();
                    canvas.drawPath(triangle, paint);
                    break;

                case SUN:
                    canvas.drawCircle(2000,250,150, paint);
                    break;

                case DOOR:
                    canvas.drawRect(850,1300, 1000, 1625, paint);
                    break;

                case WINDOW:
                    canvas.drawRect(1200,1200, 1400, 1400, paint);
                    break;

                case CLOUD:
                    canvas.drawRect(200,100, 900, 300, paint);
                    break;
            }

        }

    }

    private List<Element> elements;

    public CustomElement()
    {
        elements = new ArrayList<>();

        // Set Color for each particular element
        elements.add(new Element(HouseType.BASE, Color.BLACK));
        elements.add(new Element(HouseType.ROOF, Color.GREEN));
        elements.add(new Element(HouseType.SUN, Color.YELLOW));
        elements.add(new Element(HouseType.DOOR, Color.RED));
        elements.add(new Element(HouseType.WINDOW, Color.CYAN));
        elements.add(new Element(HouseType.CLOUD, Color.WHITE));
    }

    public List<Element> getElements()
    {
        return elements;
    }

    public Element getElement(int index)
    {
        return elements.get(index);
    }

    public int size()
    {
        return elements.size();
    }





}
