import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    static Edge[] graph;
    static boolean [] visited;
    static int[] count;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());


            graph = new Edge[n+1];
            count = new int[n+1];
            visited = new boolean[n+1];

            for(int j = 0; j<m; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                graph[a] = new Edge(b, cost, graph[a]);
                graph[b] = new Edge(a, cost, graph[b]);
                count[a]++;
                count[b]++;
            }
            visited[1] = true;
            int cost = dfs(1);
            sb.append(cost).append("\n");

        }
        System.out.println(sb);


    }

    static int dfs(int i) {

        int cost = 0;
        for (Edge e = graph[i]; e != null; e = e.next) {
            if(visited[e.to]) continue;
            visited[e.to] = true;

            if(count[e.to] == 1){
                cost += e.cost;
            }else {
                int dfs = dfs(e.to);
                int value = Math.min(e.cost, dfs);
                cost += value;
            }

//            System.out.println("currentIndex : " + i + " to : " + e.to + " min : " + value + " origin cost : " + e.cost +  " dfs cost : " +dfs );
        }


        return cost;
    }

    static class Edge{
        int to;
        int cost;
        Edge next;

        public Edge(int to, int cost, Edge next) {
            this.to = to;
            this.cost = cost;
            this.next = next;
        }
    }


}