package beak.prev.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    https://www.acmicpc.net/problem/11403
    그래프 탐색 실버 1

 */
public class P11403 {

    int[][] answerArray;
    List<LinkedList<Integer>> adj;
    public void solution() throws Exception{
        inputAndSetVariable();
        bfs(adj);
        printAnswer();
    }

    private void inputAndSetVariable() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        answerArray = new int[n][n];
        adj = new ArrayList<>();
        for(int i = 0; i<n; i++)
            adj.add(new LinkedList<>());
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                int k = Integer.parseInt(st.nextToken());
                if (k == 1) {
                    adj.get(i).add(j);
                }
                j++;
            }
        }
    }

    private void printAnswer() {
        StringBuilder sb = new StringBuilder();
        for (int[] arr : answerArray) {
            for (int k : arr) {
                sb.append(k).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public void bfs(List<LinkedList<Integer>> adj){
        for (int i = 0; i < adj.size(); i++) {
            boolean[] visited = new boolean[adj.size()];
             Queue<Integer> q = new LinkedList<>();
             q.add(i);
             visited[i] = true;
            while (!q.isEmpty()) {
                Integer poll = q.poll();

                for(Integer integer : adj.get(poll)){
                    answerArray[i][integer] = 1;
                    if(!visited[integer]){
                        visited[integer] = true;
                        q.add(integer);

                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new P11403().solution();
    }

}
