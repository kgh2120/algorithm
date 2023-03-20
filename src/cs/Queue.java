package cs;

import java.util.Stack;

public class Queue {

    Stack<Integer> s;
    Stack<Integer> q;

    public Queue() {
        s = new Stack<>();
        q = new Stack<>();
    }

    public void enqueue(int i){
        s.push(i);
    }

    public Integer dequeue(){
        if(!q.isEmpty())
            return q.pop();
        while(!s.isEmpty())
            q.push(s.pop());
        return q.pop();
    }



    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        System.out.println(q.dequeue());;
        q.enqueue(3);
        System.out.println(q.dequeue());
        q.enqueue(4);

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());


    }




}
