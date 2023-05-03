package beak.prev.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1707 {
    StringBuilder sb = new StringBuilder();
    List<LinkedList<Integer>> graph;
    int[] visited;
    private final int RED = 1;
    boolean flag;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            visited = new int[v+1];
            Arrays.fill(visited,-1);
            graph = new ArrayList<>();
            flag = false;
            for (int j = 0; j <= v; j++) {
                graph.add(new LinkedList<>());
            }

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int f = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                graph.get(f).add(t);
                graph.get(t).add(f);
            }

            for (int j = 1; j <= v; j++) {
                bfs(j);
                if(flag)
                    break;
            }

            if(flag)
                sb.append("NO\n");
            else
                sb.append("YES\n");
            

        }
        System.out.println(sb);
    }

    public void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        if (visited[start] == -1) {
            q.add(start);
            visited[start] = RED;

            while (!q.isEmpty()) {
                Integer poll = q.poll();

                for (Integer integer : graph.get(poll)) {
                    if (visited[integer] == -1) {
                        visited[integer] = 3 - visited[poll];
                        q.add(integer);
                    } else if (visited[integer] == visited[poll]) {
                        flag = true;
                        break;
                    }
                }

            }
        }

    }

    public static void main(String[] args) throws Exception {
        new P1707().solution();
    }
}





