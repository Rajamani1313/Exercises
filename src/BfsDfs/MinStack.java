package BfsDfs;

import java.util.Stack;

public class MinStack {
    /** initialize your data structure here. */
    Stack stack = new Stack();
    Stack minStack = new Stack();

    public MinStack() {
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= (int) minStack.peek()){
            System.out.println("min push:"+x);
            minStack.push(x);
        }
    }

    public void pop() {
        System.out.println("min peek:"+minStack.peek());
        System.out.println("Stack peek:"+stack.peek());
        if (!stack.isEmpty() && (int) stack.peek() == (int) minStack.peek()) {
            minStack.pop();
            System.out.println("min pop:"+minStack.peek());
        }
        stack.pop();
    }

    public int top() {
        return (int) stack.peek();
    }

    public int getMin() {
        return (int) minStack.peek();
    }
    public static void main(String[] args){
        MinStack obj = new MinStack();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }
}

/**
 * Your BfsDfs.MinStack object will be instantiated and called as such:
 * BfsDfs.MinStack obj = new BfsDfs.MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
