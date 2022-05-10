package Inflearn.Sorting;

import com.sun.tools.javac.Main;

import java.util.Arrays;
import java.util.Scanner;

public class Inflearn_6_6_CoordianteSort {
    public static void submit(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nOfNode = sc.nextInt();
        Node[] nodes = new Node[nOfNode];

        for (int i = 0; i < nOfNode; i++) {
            nodes[i] = new Node(sc.nextInt(), sc.nextInt());
        }

        Object[] objects = Arrays.stream(nodes).sorted((n1, n2) -> {

            if (n1.getX() > n2.getX()) {
                return 1;
            } else if (n1.getX() == n2.getX()) {
                return Integer.compare(n1.getY(), n2.getY());
            } else
                return -1;
        }).toArray();
        for (Object object : objects) {
            System.out.println(object);
        }

    }


    public static class Node{
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
        @Override
        public String toString() {
            return x +" "+y;
        }
    }
}
