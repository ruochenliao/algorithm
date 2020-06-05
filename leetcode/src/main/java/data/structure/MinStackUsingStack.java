package data.structure;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.


Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 */
public class MinStackUsingStack {

    private static Stack<Integer> stack = new Stack<>();
    private static int min = Integer.MAX_VALUE;

    /**
     * 如果遇到小于等于最小值的数，stack 则把老的最小值也 push 入栈
     * @param x
     */
    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    /**
     * 如果 pop 的是最小值，则 pop 两次，把老的最小值给到 min
     */
    public void pop() {
        if(stack.pop() == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStackUsingStack stackUsingStack = new MinStackUsingStack();
        stackUsingStack.push(-1);
        System.out.println(stackUsingStack.top());
        System.out.println(stackUsingStack.getMin());
    }
}
