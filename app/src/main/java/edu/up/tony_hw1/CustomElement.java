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
        BASE, ROOF, SUN, TRUNK, LEAVES, CLOUD
    }

    public static class Element
    {
        private HouseType type;
        private Paint paint;
        private RectF bounds;

        public Element(HouseType type, int color, RectF bounds)
        {
            this.type = type;
            this.paint = new Paint();
            this.paint.setColor(color);
            this.bounds = bounds;
        }

        public HouseType getType()
        {
            return type;
        }

        public int getColor()
        {
            return paint.getColor();
        }

        public void setColor(int color)
        {
            paint.setColor(color);
        }

        public boolean contains(float x, float y)
        {
            return bounds != null && bounds.contains(x, y);
        }

        public void draw(Canvas canvas)
        {
            switch (type)
            {
                // BASE ROOF SUN DOOR WINDOW CLOUD
                case BASE:
                    canvas.drawRect(bounds, paint);
                    break;

                case ROOF:
                    Path triangle = new Path();
                    triangle.moveTo(bounds.centerX(), bounds.top);
                    triangle.lineTo(bounds.left, bounds.bottom);
                    triangle.lineTo(bounds.right, bounds.bottom);
                    triangle.close();
                    canvas.drawPath(triangle, paint);
                    break;

                case SUN:
                    canvas.drawCircle(bounds.centerX(), bounds.centerY(), bounds.width() / 2, paint);
                    break;

                case TRUNK:
                    canvas.drawRect(bounds, paint);
                    break;

                case LEAVES:
                    canvas.drawRect(bounds, paint);
                    break;

                case CLOUD:
                    canvas.drawRect(bounds, paint);
                    break;
            }

        }

    }

    private List<Element> elements;

    public CustomElement()
    {
        elements = new ArrayList<>();

        elements.add(new Element(HouseType.BASE, Color.BLACK, new RectF(700, 750, 1500, 1625)));
        elements.add(new Element(HouseType.ROOF, Color.GREEN, new RectF(700, 400, 1500, 750)));
        elements.add(new Element(HouseType.SUN, Color.YELLOW, new RectF(1850, 100, 2150, 400)));
        elements.add(new Element(HouseType.TRUNK, Color.GREEN, new RectF(2350, 1100, 2500, 1625)));
        elements.add(new Element(HouseType.LEAVES, Color.CYAN, new RectF(2100, 800, 2700, 1100)));
        elements.add(new Element(HouseType.CLOUD, Color.WHITE, new RectF(200, 100, 900, 300)));
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
