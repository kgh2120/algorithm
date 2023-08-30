import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[][] graph;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < n; i++) {
            dfs(i,i,0,0);;
        }

        System.out.println(min);



    }

    private static void dfs(int startNode, int cur, int depth, int cost) {
        if(depth != n && depth != 0 && cur == startNode) return;
        if (depth == n) {
            if (cur == startNode) {
                min = Math.min(min,cost);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            int nextCost = graph[cur][i];
            if(nextCost == 0 || visited[i]) continue;
            visited[i] = true;
            dfs(startNode,i,depth+1, cost + nextCost);
            visited[i] = false;
        }

    }


}