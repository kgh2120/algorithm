package Inflearn.recursiveBFSDFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class Inflearn_7_9_MinRoute_BFS {

    static Node root;
    static class Node{
        Node l, r;
        int val;
    }

    public static void main(String[] args) {

        Node n1 = new Node();

        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        Node n5 = new Node();
        n1.val = 1; n2.val = 2; n3.val = 3; n4.val = 4; n5.val = 5;
        n1.l = n2;
        n1.r = n3;
        n2.l = n4;
        n2.r = n5;

        root = n1;
        BFS();


    }


    public static void BFS() {


        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {


            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                if (isLastNode(n)) {
                    System.out.println(level);
                    return;
                }

                if(n.l != null)
                    q.add(n.l);
                if (n.r != null) {
                    q.add(n.r);
                }

            }

            level++;
        }


    }

    public static boolean isLastNode(Node n) {
        return n.l == null && n.r == null;
    }
}
