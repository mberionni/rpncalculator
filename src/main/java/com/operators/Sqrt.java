package com.operators;

import com.Item;
import com.RPNStack;

public class Sqrt extends Operator {

    public Sqrt() {
        super("sqrt", 1);
    }

    @Override
    public void apply(RPNStack<Item> stack, double... args) {
        super.apply(stack, args);
        double ret = Math.sqrt(args[0]);
        stack.push(new Item(ret));
    }
}
