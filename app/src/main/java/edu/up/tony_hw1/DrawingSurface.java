// Tony Phan
// CS301 - Object Oriented Design
// 9/18/2025

package edu.up.tony_hw1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceView;

public class DrawingSurface extends SurfaceView {


    private CustomElement houseElement;
    private int currentIndex = 0;
    private DrawingController controller;

    private static final float canvasWidth = 1280f;
    private static final float canvasHeight = 900f;


    public DrawingSurface(Context context, DrawingModel model)
    {
        super(context);
        setWillNotDraw(false);

        setBackgroundColor(Color.BLUE);
        houseElement = new CustomElement();
    }

    public void setController(DrawingController controller)
    {
        this.controller = controller;
    }


    // Draw Method
    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        float scaleX = canvas.getWidth() / canvasWidth;
        float scaleY = canvas.getHeight() / canvasHeight;

        // Had to consult google for "scale" but basically resizes the window
        canvas.save();
        canvas.scale(scaleX, scaleY);


        for (CustomElement.Element e : houseElement.getElements())
        {
            // Looping through the elements, means that we do have a name for each type
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

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent)
    {

        if (controller != null && motionEvent.getAction() == MotionEvent.ACTION_DOWN)
        {

            float scaleX = canvasWidth / getWidth();
            float scaleY = canvasHeight / getHeight();

            float resizedX = motionEvent.getX() * scaleX;
            float resizedY = motionEvent.getY() * scaleY;

            controller.handleTouch(resizedX, resizedY);
        }

        return true;
    }


}
