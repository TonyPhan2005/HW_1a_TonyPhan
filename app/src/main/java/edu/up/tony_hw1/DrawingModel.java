package edu.up.tony_hw1;

public class DrawingModel {

    private CustomElement.Element selectedElement;
    private CustomElement elements;

    public DrawingModel()
    {
        elements = new CustomElement();
    }

    public CustomElement getElements()
    {
        return elements;
    }

    public void setSelectedElements(CustomElement.Element e)
    {
        selectedElement = e;
    }

    public CustomElement.Element getSelectedElements()
    {
        return selectedElement;
    }
}

