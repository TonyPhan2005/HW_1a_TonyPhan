package edu.up.tony_hw1;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class DrawingController implements SeekBar.OnSeekBarChangeListener, View.OnTouchListener {


    // All used variables
    private DrawingModel model;
    private DrawingSurface drawingSurface;
    private TextView nameElement;

    private SeekBar redSeek;
    private SeekBar greenSeek;
    private SeekBar blueSeek;

    // Initializing all variables to be within the scope
    // Controller class implements most of the function/control
    public DrawingController(DrawingModel model, DrawingSurface drawingSurface, TextView nameElement, SeekBar redSeek, SeekBar greenSeek, SeekBar blueSeek)
    {
        this.model = model;
        this.drawingSurface = drawingSurface;
        this.nameElement = nameElement;
        this.redSeek = redSeek;
        this.greenSeek = greenSeek;
        this.blueSeek = blueSeek;

        redSeek.setOnSeekBarChangeListener(this);
        greenSeek.setOnSeekBarChangeListener(this);
        blueSeek.setOnSeekBarChangeListener(this);

    }

    public void handleTouch(float x, float y)
    {

        for(customElement.Element e : model.getElements())
        {

            if(e.withinBounds(x, y))

        }

    }

    public void selectedElement(CustomElement element)
    {

        model.getSelectedElement(element);
        nameElement.setText(element.getName());

    }








}
