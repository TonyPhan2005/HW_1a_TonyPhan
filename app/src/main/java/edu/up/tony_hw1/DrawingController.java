// Tony Phan
// CS301 - Object Oriented

package edu.up.tony_hw1;

import static edu.up.tony_hw1.DrawingSurface.CANVAS_HEIGHT;
import static edu.up.tony_hw1.DrawingSurface.CANVAS_WIDTH;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

public class DrawingController implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener{

    private DrawingSurface drawingSurface;
    private DrawingModel model;

    // Initializing variables to be within scope
    public DrawingController(DrawingSurface surface, DrawingModel model)
    {
        this.drawingSurface = surface;
        this.model = model;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event)
    {

        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {

            float scaleX = (float) drawingSurface.getWidth() / CANVAS_WIDTH;
            float scaleY = (float) drawingSurface.getHeight() / CANVAS_HEIGHT;
            float scale = Math.min(scaleX, scaleY);

            float x = event.getX() / scale;
            float y = event.getY() / scale;

            for(int i = 0; i < model.customElement.size(); i++)
            {
                CustomElement.Element e = model.customElement.getElement(i);
                if(e.contains(x, y))
                {
                    model.currentIndex = i;

                    model.elementName.setText(e.getType().name());

                    int color = e.getColor();
                    model.redSeek.setProgress(Color.red(color));
                    model.greenSeek.setProgress(Color.green(color));
                    model.blueSeek.setProgress(Color.blue(color));

                    drawingSurface.invalidate();
                    break;
                }

            }

        }
        return true;
    }

    // Handle SeekBar Colors
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if(!fromUser) return;

        CustomElement.Element current = model.getCurrentElement();
        if(current == null)
        {
            return;
        }

        if(fromUser)
        {
            // Option 1
            int red = model.redSeek.getProgress();
            int green = model.greenSeek.getProgress();
            int blue = model.blueSeek.getProgress();

            model.customElement.getElement(model.currentIndex).setColor(Color.rgb(red, green, blue));

            drawingSurface.invalidate();
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}
