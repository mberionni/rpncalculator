package com.operators;

import com.Item;
import com.RPNStack;

public class Addition extends Operator {

    public Addition() {
        super("+", 2);
    }

    @Override
    public void apply(RPNStack<Item> stack, double... args) {
        super.apply(stack, args);
        double ret = args[1] + args[0];
        stack.push(new Item(ret));
    }
}
