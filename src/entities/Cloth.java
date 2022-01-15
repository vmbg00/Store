package entities;

import enums.ClothSize;
import enums.Color;

public class Cloth extends BaseEntity {
    private ClothSize size;
    private Color color;

    public Cloth() {
    }

    public ClothSize getSize() {
        return size;
    }

    public void setSize(ClothSize size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
