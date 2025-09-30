// Tony Phan
// CS301 - Object Oriented Design
// 9/18/2025

package edu.up.tony_hw1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class DrawingSurface extends SurfaceView {

    public static final float CANVAS_WIDTH = 2200f;
    public static final float CANVAS_HEIGHT = 1700f;

    private CustomElement houseElement;
    private int currentIndex = 0;

    public DrawingSurface(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setWillNotDraw(false);

        setBackgroundColor(Color.BLUE);
        houseElement = new CustomElement();
    }


    // Draw Method
    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        float scaleX = (float) getWidth() / CANVAS_WIDTH;
        float scaleY = (float) getHeight() / CANVAS_HEIGHT;

        float scale = Math.min(scaleX, scaleY);

        canvas.save();
        canvas.scale(scale, scale);

        for (CustomElement.Element e : houseElement.getElements())
        {
            // For each element in the list, draw it
            e.draw(canvas);
        }

        canvas.restore();
    }

    public void setElementColor(int color)
    {
        houseElement.getElement(currentIndex).setColor(color);
        invalidate();
    }

    public CustomElement getModel()
    {
        return houseElement;
    }

}
