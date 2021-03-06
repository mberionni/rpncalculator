package com.operators;

import com.Item;
import com.RPNStack;

public class Division extends Operator {

    public Division() {
        super("/", 2);
    }

    @Override
    public void apply(RPNStack<Item> stack, double... args) {
        super.apply(stack, args);
        double res = args[1] / args[0];
        stack.push(new Item(res));
    }
}
