package edu.up.tony_hw1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public class CustomElement {

    public enum HouseType
    {
        BASE, ROOF, SUN, DOOR, WINDOW, CLOUD
    }

    public static class Element {
        private HouseType type;
        private Paint paint;

        private String name;

        private RectF bounds;

        public Element(HouseType type, int color) {
            this.type = type;
            this.paint = new Paint();
            this.paint.setColor(color);
        }

        public HouseType getType() {
            return type;

        }

        public int getColor() {
            return paint.getColor();
        }

        public String getName()
        {
            return name;
        }

        public void setColor(int color)
        {
            paint.setColor(color);
        }

        public boolean withinBounds(float x, float y)
        {
            return bounds.contains(x, y);
        }

        public void draw(Canvas canvas)
        {
            switch (type)
            {
                // BASE ROOF SUN DOOR WINDOW CLOUD
                case BASE:

                    bounds.set(700, 750, 1500, 1625);
                    canvas.drawRect(bounds, paint);

                    // canvas.drawRect(700, 750, 1500, 1625, paint);
                    break;

                case ROOF:
                    bounds.set(700, 400, 1500, 750);
                    Path triangle = new Path();

                    triangle.moveTo(1125, 400);
                    triangle.moveTo(700, 750);
                    triangle.moveTo(1500, 750);

                    triangle.close();
                    canvas.drawPath(triangle, paint);
                    break;

                case SUN:
                    bounds.set(1850, 100, 2150, 400);
                    // canvas.drawCircle(2000,250,150, paint);

                    canvas.drawCircle(2000, 250, 150, paint);
                    break;

                case DOOR:
                    bounds.set(850, 1300, 1000, 1625);
                    canvas.drawRect(bounds, paint);
                    break;

                case WINDOW:
                    bounds.set(1200,1200, 1400, 1400);
                    canvas.drawRect(bounds, paint);
                    break;

                case CLOUD:
                    bounds.set(200,100, 900, 300);
                    canvas.drawRect(bounds, paint);
                    break;
            }

        }

    }

    private List<Element> elements;

    public CustomElement()
    {
        elements = new ArrayList<>();

        // Set Color for each particular element
        elements.add(new Element(HouseType.BASE, Color.RED));
        elements.add(new Element(HouseType.ROOF, Color.GREEN));
        elements.add(new Element(HouseType.SUN, Color.YELLOW));
        elements.add(new Element(HouseType.DOOR, Color.BLACK));
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
