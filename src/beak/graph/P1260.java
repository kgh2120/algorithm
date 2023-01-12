package beak.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260 {

    StringBuilder sb = new StringBuilder();
    boolean[] visitied;
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
        visitied = new boolean[nOfVertex+1];

        for (int i = 0; i < nOfDirection; i++) {
            st = new StringTokenizer(br.readLine());
            Integer f = Integer.valueOf(st.nextToken());
            Integer r = Integer.valueOf(st.nextToken());
            matrix.get(f).add(r);
            matrix.get(r).add(f);
        }


        dfs(matrix,startNode);
        clear();
        bfs(matrix,startNode);



        System.out.println(sb);

    }

    public void bfs(ArrayList<LinkedList<Integer>>matrix, int node) {

        Queue<Integer> queue = new LinkedList<>();
        visitied[node] = true;
        queue.add(node);
        sb.append(node).append(" ");
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            LinkedList<Integer> adjacent = matrix.get(poll);
            Collections.sort(adjacent);
            for (Integer integer : adjacent) {
                if (visitied[integer] == false) {
                    queue.add(integer);
                    visitied[integer] = true;
                    sb.append(integer).append(" ");
                }
            }
        }
    }

    public void dfs(ArrayList<LinkedList<Integer>>matrix, int node) {
        LinkedList<Integer> integers = matrix.get(node);
        Collections.sort(integers);
        visitied[node] = true;
        sb.append(node).append(" ");

        for (Integer integer : integers) {
            if (visitied[integer] == false) {
                dfs(matrix,integer);
            }
        }

    }

    public void clear(){
        seq = 0;
        Arrays.fill(this.visitied,false);
        sb.append("\n");
    }




    public static void main(String[] args) throws Exception {
        new P1260().solution();
    }
}





