package com.operators;

import com.Item;
import com.RPNStack;

public class Clear extends Operator {

    public Clear() {
        super("clear", 0);
    }

    @Override
    public void apply(RPNStack<Item> stack, double... args) {
        super.apply(stack, args);
        stack.clear();
    }
}
