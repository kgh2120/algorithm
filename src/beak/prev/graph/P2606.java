package beak.prev.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2606 {

    StringBuilder sb = new StringBuilder();
    boolean[] visitied;
    int seq = 0;




    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nOfVertex = Integer.parseInt(br.readLine());
        int nOfDirection = Integer.parseInt(br.readLine());
        int startNode = 1;

        ArrayList<LinkedList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i <= nOfVertex; i++) {
            matrix.add(new LinkedList<>());
        }
        visitied = new boolean[nOfVertex+1];

        for (int i = 0; i < nOfDirection; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer f = Integer.valueOf(st.nextToken());
            Integer r = Integer.valueOf(st.nextToken());
            matrix.get(f).add(r);
            matrix.get(r).add(f);
        }
        bfs(matrix,startNode);


        System.out.println(seq);

    }

    public void bfs(ArrayList<LinkedList<Integer>>matrix, int node) {


        Queue<Integer> queue = new LinkedList<>();
        visitied[node] = true;
        queue.add(node);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            LinkedList<Integer> adjacent = matrix.get(poll);
            adjacent.sort(Collections.reverseOrder());
            for (Integer integer : adjacent) {
                if (visitied[integer] == false) {
                    queue.add(integer);
                    seq ++ ;
                    visitied[integer] = true;
                }
            }
        }
    }




    public static void main(String[] args) throws Exception {
        new P2606().solution();
    }
}





