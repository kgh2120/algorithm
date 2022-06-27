package Inflearn.recursiveBFSDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Inflearn_7_13_findRoute_List {


    ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

    int[] prev;
    int ans = 0;

    public void init(int n) {
        for (int i = 0; i < n+1; i++) {
            edges.add(new ArrayList<>());
        }
        prev = new int[n+1];
        prev[1] = 1;
    }

    public void redraw() {
        Arrays.fill(prev,0);
        prev[1] = 1;
    }

    public void DFS(int v, int target) {
        if (v == target) {
            ans++;
            redraw();
            return;
        }

        for (Integer vertex : edges.get(v)) {
            if (prev[vertex] == 0) {
                prev[vertex]=1;
                DFS(vertex, target);
            }
        }
    }





    public static void main(String[] args) {
        Inflearn_7_13_findRoute_List m = new Inflearn_7_13_findRoute_List();
        Scanner sc = new Scanner(System.in);
        int nOfv = sc.nextInt();
        int nOfe = sc.nextInt();
        m.init(nOfv);
        for (int i = 0; i < nOfe; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            m.edges.get(from).add(to);
        }

        m.DFS(1,5);
        System.out.println(m.ans);

    }
}
