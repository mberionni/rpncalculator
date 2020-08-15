package com.operators;

import com.Item;
import com.RPNStack;

public abstract class Operator {

    String symbol;
    int numArgs;

    public Operator(String symbol, int numArgs) {
        this.symbol = symbol;
        this.numArgs = numArgs;
    }

    public void apply(RPNStack<Item> stack, double... args) {
        if (args.length != getNumArgs()) {
            throw new IllegalArgumentException("The operator " + getSymbol() + " accepts " + getNumArgs() +
                    " operands, but " + args.length + " have been supplied");
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public int getNumArgs() {
        return numArgs;
    }
}
