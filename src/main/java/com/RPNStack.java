package com;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RPNStack<Item> {
    private ArrayDeque<Item> stack;
    private final List<ArrayDeque<Item>> history;
    private int index;

    public RPNStack() {
        this.stack = new ArrayDeque<>();
        this.history = new ArrayList<>();
        this.index = 0;
    }

    public void push(Item item) {
        stack.push(item);
        log();
    }

    public Item pop() {
        return stack.pop();
    }

    private void log() {
        if (history.isEmpty()) {
            history.add(index, new ArrayDeque<>());
        }
        index++;
        history.add(index, stack.clone());
    }

    public void clear() {
        stack.clear();
        history.clear();
        index = 0;
    }

    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Item> it = stack.iterator();
        if (!it.hasNext()) {
            return "stack:";
        }
        for (;;) {
            Item e = it.next();
            sb.insert(0, ' ' + e.toString());
            if (!it.hasNext()) {
                return sb.insert(0, "stack:").toString();
            }
        }
    }

    public void undo() {
        if (index == 0) {
            return;
        }
        index--;
        this.stack = history.get(index).clone();
    }

    public void redo() {
        if (index >= (history.size() - 1)) {
            return;
        }
        index++;
        this.stack = history.get(index);
    }
}
