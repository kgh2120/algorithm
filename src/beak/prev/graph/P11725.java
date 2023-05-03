package beak.prev.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 *  https://www.acmicpc.net/problem/11725
 *  그래프 탐색 실버 2
 *  쉬운 문제였다. 근데 답을 찍는 과정에서 순서를 실수함.
 *
 */
public class P11725 {


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<LinkedList<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        for(int i = 0; i<=n; i++)
            adj.add(new LinkedList<>());

        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            adj.get(f).add(t);
            adj.get(t).add(f);
        }

        bfs(adj,visited);

    }

    private void bfs(List<LinkedList<Integer>> adj, boolean[] visited ){
        Queue<Integer> q = new LinkedList<>();
        int[] answer = new int[visited.length];

        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()){
            Integer poll = q.poll();

            for (Integer integers : adj.get(poll)) {
                if (!visited[integers]) {

                    visited[integers] = true;
                    q.add(integers);
                    answer[integers] = poll;

                }
            }
        }

        for (int i = 2; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }




    public static void main(String[] args) throws Exception {
        new P11725().solution();
    }

}
