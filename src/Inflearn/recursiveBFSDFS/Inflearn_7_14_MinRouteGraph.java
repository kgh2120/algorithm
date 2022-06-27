package Inflearn.recursiveBFSDFS;

import java.util.*;

public class Inflearn_7_14_MinRouteGraph {

    ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

    int []prev;
    public void init (int n) {
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        prev = new int[n + 1];
        prev[1] = 1;
    }
    public void redraw() {
        Arrays.fill(prev,0);
        prev[1] = 1;
    }

    public void minRoute(int target) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer v = q.poll();
                if (v == target) {
                    System.out.println(level);
                    return;
                }

                for (Integer adjV : edges.get(v)) {
                    if (prev[adjV] == 0) {
                        prev[adjV]=1;
                        q.add(adjV);
                    }
                }
            }
            level++;
        }
    }



    public static void main(String[] args) {
        Inflearn_7_14_MinRouteGraph m = new Inflearn_7_14_MinRouteGraph();
        Scanner sc = new Scanner(System.in);
        int nOfV = sc.nextInt();
        int nOfE = sc.nextInt();

        m.init(nOfV);
        for (int i = 0; i < nOfE; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            m.edges.get(from).add(to);
        }

        for (int i = 2; i <= nOfV; i++) {
            m.minRoute(i);
            m.redraw();
        }
    }
}
