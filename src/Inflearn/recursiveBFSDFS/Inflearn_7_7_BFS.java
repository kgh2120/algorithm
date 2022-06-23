package Inflearn.recursiveBFSDFS;

import java.util.ArrayDeque;
import java.util.Deque;

public class Inflearn_7_7_BFS {
    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

    static Node root;

    public static void main(String[] args) {
        Node[] nodes = new Node[8];

        for (int i = 1; i < 8; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i < 8; i++) {
            if(2*i >= 8 ) continue;
            nodes[i].left = nodes[2*i];
            nodes[i].right = nodes[2*i +1];
        }

        root = nodes[1];

        BFS();




    }

    public static void BFS() {
        System.out.println("<< BFS >> ");
        Deque<Node> d = new ArrayDeque<>();
        d.push(root);
        while (!d.isEmpty()) {

            int size = d.size();
            for (int i = 0; i < size; i++) {
                Node n = d.pop();
                System.out.print(n.value + " ");
                if(n.left != null)
                    d.add(n.left);
                if(n.right != null)
                    d.add(n.right);
            }
        }

    }
}
