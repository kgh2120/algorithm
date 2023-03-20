package cs;

import java.util.LinkedList;
import java.util.Queue;

public class Stack {

    private Queue<Integer> push;
    private Queue<Integer> pop;

    public Stack() {
        push = new LinkedList<>();
        pop = new LinkedList<>();
    }

    public void push(int i){
        push.add(i);
    }
    public int pop() {
        int size = push.size();
        for(int i = 0; i<size-1; i++)
            pop.add(push.poll());
        int retVal = push.poll();

        Queue<Integer> temp = push;
        push = pop;
        pop = temp;
        return retVal;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }

    }

}
