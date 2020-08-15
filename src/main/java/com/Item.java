package com;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Item {
    private final double num;
    /* Add a field "position" in order to customize the color of the number depending on the position */
    private static final DecimalFormat df = new DecimalFormat("#.##########");
    static {
        df.setRoundingMode(RoundingMode.DOWN);
    }

    public Item(double n) {
        this.num = n;
    }

    public double getNum() {
        return num;
    }

    @Override
    public String toString() {
        return df.format(num);
    }
}
