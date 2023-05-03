package programmers.prev.random;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class CoupleSecret {

    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] parents = new int[n+1];
        List<LinkedList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n+1; i++)
            adj.add(new LinkedList<>());

        StringTokenizer st;
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            adj.get(f).add(t);
            adj.get(t).add(f);
        }

        bfs(parents,adj);
        for (int i = 2; i < n+1; i++) {
            System.out.println(parents[i]);
        }

    }

    private static void bfs(int[] parents, List<LinkedList<Integer>> adj) {

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        parents[1] = 1;

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (Integer i : adj.get(poll)) {
                if(parents[i] != 0)
                    continue;
                parents[i] = poll;
                q.add(i);
            }
        }
    }








}