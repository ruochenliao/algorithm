package data.structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用queue 来实现 stack
 */
public class ImplementStackUsingQueues {

    public static Queue<Integer> queue;

    ImplementStackUsingQueues(){
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x){
        int size = queue.size();
        queue.offer(x);
        for(int i = 0; i < size; i++){
            queue.offer(queue.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop(){
        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues stack = new ImplementStackUsingQueues();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}
