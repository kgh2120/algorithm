package Inflearn.recursiveBFSDFS;

import java.util.*;

public class Inflearn_7_14_MinRouteGraph_dis {

    ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

    int []prev;
    int[] dist;
    public void init (int n) {
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        prev = new int[n + 1];
        dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1] = 0;
        prev[1] = 1;
    }
    public void redraw() {
        Arrays.fill(prev,0);
        prev[1] = 1;
    }

    public void minRoute() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer v = q.poll();

                for (Integer adjV : edges.get(v)) {
                    if (prev[adjV] == 0) {
                        prev[adjV]=1;
                        dist[adjV] = dist[v]+1;
                        q.add(adjV);
                    }
                }
            }
        }
    }



    public static void main(String[] args) {
        Inflearn_7_14_MinRouteGraph_dis m = new Inflearn_7_14_MinRouteGraph_dis();
        Scanner sc = new Scanner(System.in);
        int nOfV = sc.nextInt();
        int nOfE = sc.nextInt();

        m.init(nOfV);
        for (int i = 0; i < nOfE; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            m.edges.get(from).add(to);
        }

       m.minRoute();
        for (int i = 2; i <= nOfV; i++) {
            System.out.println(m.dist[i]);
        }
    }
}
