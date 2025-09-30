package edu.up.tony_hw1;

import android.widget.SeekBar;
import android.widget.TextView;

public class DrawingModel {

    // public CustomElement houseElement;

    CustomElement houseElement = new CustomElement();
    public int currentIndex = -1;

    // References to UI
    public TextView elementName;
    public SeekBar redSeek;
    public SeekBar greenSeek;
    public SeekBar blueSeek;


    public CustomElement customElement;

    public DrawingModel(CustomElement element)
    {
        this.customElement = element;
    }

    public CustomElement.Element getCurrentElement()
    {
        if (currentIndex >= 0 && currentIndex < houseElement.size())
        {
            return houseElement.getElement(currentIndex);
        }
        // Else, return null/empty
        return null;
    }

}


