package multiplethread;

import java.util.LinkedList;

public class MyStack<Object> {
    LinkedList<Object> stack = new LinkedList<>();

    public synchronized void push (Object o) {
        while (this.stack.size() >= 200) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stack.addLast(o);
        this.notify();
    }

    public synchronized Object pull () {
        while (this.stack.size() <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        return stack.removeLast();
    }

    public synchronized Object peek() {
        return stack.getLast();
    }
}
