import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();



    static int n,k;
    static int[] cost;
    static Edge[] edges;
    static int[] edgeCounts;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            cost = new int[n+1];
            edges = new Edge[n+1];
            edgeCounts = new int[n+1];
            dist = new int[n+1];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n ; j++) {
                cost[j] = Integer.parseInt(st.nextToken());
            }


            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                edges[from] = new Edge(to,edges[from]);
                // to가 없으면 처음이 가능함.
                edgeCounts[to]++;
            }

            int end = Integer.parseInt(br.readLine());
            // start index를 잡아야 함.
            //

            int[] temp = new int[n+1];
            int min = Integer.MAX_VALUE;
            if (edgeCounts[end] == 0) {
                min = cost[end];
            }else{
                Arrays.fill(dist,-1);
                System.arraycopy(edgeCounts,0,temp,0,n+1);
                bfs(end,temp);
                if(dist[end] == -1) continue;
                min = Math.min(min, dist[end]);

            }
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int end, int[] tempEdgeCounts){
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n ; i++) {
            if (tempEdgeCounts[i] == 0) {
                q.add(i);
                dist[i] = cost[i];
            }
        }


        while (!q.isEmpty()) {
            Integer poll = q.poll();
            if(poll == end)
                break;

            Edge edge = edges[poll];
            while (edge != null) {
                tempEdgeCounts[edge.t]--;

                if (dist[edge.t] < dist[poll] + cost[edge.t]) {
                    dist[edge.t] = dist[poll] + cost[edge.t];
                }
                if(tempEdgeCounts[edge.t]==0)
                    q.add(edge.t);

                edge = edge.next;
            }
        }

    }



    static class Edge{

        int t;
        Edge next;

        public Edge( int t, Edge next) {
            this.t = t;
            this.next = next;
        }


    }


}