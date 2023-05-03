package beak.prev.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P24444 {

    StringBuilder sb = new StringBuilder();
    int[] visitied;
    int seq = 0;




    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nOfVertex = Integer.parseInt(st.nextToken());
        int nOfDirection = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        ArrayList<LinkedList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i <= nOfVertex; i++) {
            matrix.add(new LinkedList<>());
        }
        visitied = new int[nOfVertex+1];

        for (int i = 0; i < nOfDirection; i++) {
            st = new StringTokenizer(br.readLine());
            Integer f = Integer.valueOf(st.nextToken());
            Integer r = Integer.valueOf(st.nextToken());
            matrix.get(f).add(r);
            matrix.get(r).add(f);
        }
        bfs(matrix,startNode);
        for (int i = 1; i <= nOfVertex; i++) {
            sb.append(visitied[i]).append("\n");
        }

        System.out.println(sb.toString());

    }

    public void bfs(ArrayList<LinkedList<Integer>>matrix, int node) {


        Queue<Integer> queue = new LinkedList<>();
        visitied[node] = ++seq;
        queue.add(node);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            LinkedList<Integer> adjacent = matrix.get(poll);
            Collections.sort(adjacent);
            for (Integer integer : adjacent) {
                if (visitied[integer] == 0) {
                    queue.add(integer);
                    visitied[integer] = ++seq;
                }
            }
        }
    }




    public static void main(String[] args) throws Exception {
        new P24444().solution();
    }
}





