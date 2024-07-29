import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] cnt = new int[n + 1];
        Node[] graph = new Node[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            cnt[to]++;
            graph[from] = new Node(to, graph[from]);
        }

        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if(cnt[i] == 0)
                q.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()) {
            Integer poll = q.poll();

            sb.append(poll).append(" ");

            for(Node node = graph[poll]; node != null; node = node.next) {
                if(--cnt[node.to]==0)
                    q.add(node.to);
            }
        }
        System.out.println(sb);


    }

    static class Node{
        int to;
        Node next;

        public Node(int to, Node next) {
            this.to = to;
            this.next = next;
        }
    }

}