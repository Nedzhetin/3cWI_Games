package at.nejo.test2;

import java.awt.*;

public class Shoe extends AbstractProduct {
    private Color color;

    public Shoe(int id, String title, String description, double price) {
        super(id, title, description, price);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

