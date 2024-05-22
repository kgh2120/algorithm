import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import org.w3c.dom.Node;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Node[] graphs;
    static int []cost;
    static int[] clear;

    public static void main(String[] args) throws Exception{

        int n = Integer.parseInt(br.readLine());

        cost = new int[n + 1];
        clear = new int[n + 1];
        graphs = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int numberOfNext = Integer.parseInt(st.nextToken());
            cost[i] = c;
            clear[i] = numberOfNext;

            for (int j = 0; j < numberOfNext; j++) {
                int next = Integer.parseInt(st.nextToken());
                graphs[next] = new Node(i, graphs[next]);
            }
        }

        Queue<Block> pq = new PriorityQueue<>();

        for (int i = 1; i <= n ; i++) {
            if (clear[i] == 0) {
                pq.add(new Block(i, cost[i]));
            }
        }

        int time = -1;
        while (!pq.isEmpty()) {
            Block poll = pq.poll();
            time = Math.max(time, poll.w);
            for(Node node = graphs[poll.index]; node != null; node = node.next){
                if (--clear[node.number] == 0) {
                    pq.add(new Block(node.number, cost[node.number] + poll.w));
                }
            }
        }
        System.out.println(time);



    }
    static class Block implements Comparable<Block>{
        int index;
        int w;

        public Block(int i, int w) {
            index = i;
            this.w = w;
        }

        @Override
        public int compareTo(Block o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static class Node{
        int number;
        Node next;

        public Node(int number, Node next) {
            this.number = number;
            this.next = next;
        }
    }


}