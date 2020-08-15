package com.operators;

import com.Item;
import com.RPNStack;

public class Undo extends Operator {

    public Undo() {
        super("undo", 0);
    }

    @Override
    public void apply(RPNStack<Item> stack, double... args) {
        super.apply(stack, args);
        stack.undo();
    }
}
