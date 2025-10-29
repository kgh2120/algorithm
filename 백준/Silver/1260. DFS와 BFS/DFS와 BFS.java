import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static List<Integer>[] graph;
    static boolean[] visited ;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        graph = new List[n+1];
        for(int i =0; i<= n; i++)
            graph[i] = new ArrayList<>();


        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        for(List<Integer> l : graph)
            Collections.sort(l);

        visited = new boolean[n+1];

        dfs(start);
        answer.append("\n");
        visited = new boolean[n+1];
        bfs(start);
        System.out.print(answer);

    }

    static void bfs(int vertex){

        Queue<Integer> q = new ArrayDeque<>();

        q.add(vertex);
        visited[vertex] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            answer.append(cur).append(" ");
            for(int t : graph[cur]){
                if(!visited[t]){
                    visited[t] = true;
                    q.add(t);
                }
            }
        }


    }


    static void dfs(int vertex){
        answer.append(vertex).append(" ");
        visited[vertex] = true;
        for(int t : graph[vertex]){
            if(!visited[t]){
                dfs(t);
            }
        }

    }
}
