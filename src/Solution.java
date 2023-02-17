import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {


    static class Node implements Comparable<Node>{

        int w;

        public Node(int i) {
            w = i;
        }

        @Override
        public int compareTo(Node o) {
            if(w < o.w)
                return 1;
            else return -1;
        }
    }


    public static void main(String[] args) {

        PriorityQueue<Node> nodes = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            nodes.add(new Node(i));
        }

        while (!nodes.isEmpty()) {
            System.out.println(nodes.poll().w);
        }


    }
}