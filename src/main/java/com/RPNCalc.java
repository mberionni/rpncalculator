package com;

import com.operators.Division;
import com.operators.Multiplication;
import com.operators.Operator;
import com.operators.Addition;
import com.operators.Clear;
import com.operators.Redo;
import com.operators.Sqrt;
import com.operators.Subtraction;
import com.operators.Undo;

import javax.annotation.Nonnull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RPNCalc implements RPNCalcInterface {

    private final RPNStack<Item> stack = new RPNStack<>();
    private static final Map<String, Operator> operators;

    static {
        operators = new HashMap<>();
        Addition oa = new Addition();
        operators.put(oa.getSymbol(), oa);
        Subtraction os = new Subtraction();
        operators.put(os.getSymbol(), os);
        Division od = new Division();
        operators.put(od.getSymbol(), od);
        Multiplication om = new Multiplication();
        operators.put(om.getSymbol(), om);
        Clear oc = new Clear();
        operators.put(oc.getSymbol(), oc);
        Undo ou = new Undo();
        operators.put(ou.getSymbol(), ou);
        Redo or = new Redo();
        operators.put(or.getSymbol(), or);
        Sqrt osqrt = new Sqrt();
        operators.put(osqrt.getSymbol(), osqrt);
    }

    private void readProcessInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            boolean quit = false;
            while (!quit && (line = reader.readLine()) != null) {
                String ret = process(line);
                quit = ret.equals("quit");
            }
        } catch (IOException | NumberFormatException e) {
            msg("Exception while reading input: " + e);
        }
    }

    @Override
    @Nonnull
    public String process(@Nonnull String line) {
        String[] tokens = line.split(" ");
        int pos = 0;
        for (String token : tokens) {
            pos += 2;
            if(token.equals("quit")) {
                return token;
            }
            if (operators.containsKey(token)) {
                Operator op = operators.get(token);
                boolean applied = apply(op, pos);
                if (!applied) {
                    break;
                }
                continue;
            }
            double num = Double.parseDouble(token);
            Item item = new Item(num);
            stack.push(item);
        }
        String ret = stack.toString();
        msg(ret);
        return ret;
    }

    @Override
    public void clearState() {
        stack.clear();
    }

    private boolean apply(@Nonnull Operator op, int pos) {
        int numArgs = op.getNumArgs();
        if (stack.size() < numArgs) {
            msg("operator " + op.getSymbol() + " (position " + (pos - 1) + "): insufficient parameters");
            return false;
        }
        double[] args = new double[numArgs];
        for (int i = 0; i < numArgs; i++) {
            Item item = stack.pop();
            args[i] = item.getNum();
        }
        op.apply(stack, args);
        return true;
    }

    private static void msg(String m) {
        System.out.println(m);
    }

    public static void main(String[] args) {
        RPNCalc rpn = new RPNCalc();
        rpn.readProcessInput();
    }
}
