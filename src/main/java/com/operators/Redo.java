package com.operators;

import com.Item;
import com.RPNStack;

public class Redo extends Operator {

    public Redo() {
        super("redo", 0);
    }

    @Override
    public void apply(RPNStack<Item> stack, double... args) {
        super.apply(stack, args);
        stack.redo();
    }
}
