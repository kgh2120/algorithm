package Inflearn.recursiveBFSDFS;

import com.sun.tools.javac.Main;

import java.util.Arrays;
import java.util.Scanner;

public class inflearn_7_12_findRoute_DFS {


    int[][] matrix;
    int[]p;
    int answer = 0;

    public void initPath() {
        Arrays.fill(p, -1);
        p[1] = 1;
    }

    public int[] adj(int v) {
        int[] adj = new int[matrix.length];

        for (int i = 1; i < matrix.length; i++) {
            if(matrix[v][i]==1)
                adj[i] = 1;
        }
        return adj;
    }

    public void DFS(int vertex, int target) {
        // 종료조건
        if (vertex == target) {
            answer++;
            initPath();
            return;
        }

        int[] adj = adj(vertex);
        p[vertex] =1;
        for (int i = 0; i < adj.length; i++) { // 인접한 vertex고 이전에 방문한 적 없다면
            if (adj[i] == 1 && p[i]==-1) {
                DFS(i,target);
            }
        }



    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inflearn_7_12_findRoute_DFS g = new inflearn_7_12_findRoute_DFS();
        int n = sc.nextInt();
        int c = sc.nextInt();
        g.matrix = new int[n + 1][c + 1];
        g.p = new int[n + 1];



        for (int i = 0; i < c; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            g.matrix[row][col] =1;
        }
        g.initPath();
        // --- 사전 준비 끝----

        g.DFS(1, 5);

        System.out.println(g.answer);


    }
}
