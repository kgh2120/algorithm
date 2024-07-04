import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Node[] graph;
    static Log[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new Node[n];
        visited = new Log[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from] = new Node(to, weight, graph[from]);

        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, null));
        visited[0] = new Log(0, 0);

        int turn = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            turn++;
            while (size-- > 0) {
                Node node = queue.poll();
                for (Node next = graph[node.to]; next != null; next = next.next) {
                    long cost = visited[node.to].value + next.cost;
                    if (visited[next.to] == null) {
                        visited[next.to] = new Log(turn, cost);
                        queue.add(new Node(next.to, cost, null));
                    } else if (visited[next.to].turn == turn && visited[next.to].value > cost) {
                        visited[next.to] = new Log(turn, cost);
                        queue.add(new Node(next.to, cost, null));
                    }
                }
            }
        }
        System.out.println(visited[1].value);
    }


    static class Node {
        int to;
        long cost;
        Node next;

        public Node(int t, long c, Node n) {
            to = t;
            cost = c;
            next = n;
        }
    }

    static class Log {
        int turn;
        long value;

        public Log(int t, long v) {
            turn = t;
            value = v;
        }
    }
}