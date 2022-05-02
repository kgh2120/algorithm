package Inflearn.StackQueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Inflearn_5_6_savePrincess {
    public static void answer(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nOfHero = sc.nextInt();
        int die = sc.nextInt();
        Node[] nList = new Node[nOfHero];
        // create node
        for (int i = 0; i < nOfHero; i++) {
            nList[i] = new Node(i + 1);
        }
        // setting relation
        for (int i = 0; i < nOfHero-1; i++) {
            nList[i].setNext(nList[i+1]);
        }
        nList[nOfHero-1].setNext(nList[0]);

        Node root = nList[0];
        kill(root,die);

    }
    public static void kill(Node e, int die) {

        Node prev = e;
        Node target = prev.next;
        int loop = 2;
        while (loop < die) {
            prev = target;
            target = target.next;
            loop++;
        }
        prev.setNext(target.getNext());
        if (prev.getValue() == prev.next.getValue()) {
            System.out.println(prev.getValue());
            return;
        }

        kill(prev.getNext(),die);

    }
    static class Node{
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void solution(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nOfHero = sc.nextInt();
        int die = sc.nextInt();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nOfHero; i++) {
            queue.add(i+1);
        }

        while (queue.size() != 1) {
            int count = 1;
            while (count < die) {
                queue.add(queue.poll());
                count++;
            }
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
