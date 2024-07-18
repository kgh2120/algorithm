import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Node> ownerQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.o, o2.o)  * -1;
            }
        });

        Queue<Node> judgeQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.j, o2.j) * -1;
            }
        });

        boolean [] isSelected = new boolean[n];



        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            Node e = new Node(i, o, j);
            ownerQueue.add(e);
            judgeQueue.add(e);

        }


         long value = 0;

        for (int i = 0; i < k; i++) {
            Node node = judgeQueue.poll();
            isSelected[node.index] = true;
            value += node.o;

        }

        for (int i = 0; i < m; ) {
            Node node = ownerQueue.poll();
            if(isSelected[node.index])
                continue;
            value += node.o;
            i++;
        }
        System.out.println(value);



    }

    static class Node  {
        int index;
        int o;
        int j;

        public Node(int index, int o, int j) {
            this.index = index;
            this.o = o;
            this.j = j;
        }
    }




}