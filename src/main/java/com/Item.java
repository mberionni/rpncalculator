package com;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Item {
    private final double num;
    private static final DecimalFormat df;
    static {
        df = new DecimalFormat("#.##########");
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
