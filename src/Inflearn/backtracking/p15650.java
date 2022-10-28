package Inflearn.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백트레킹 예제2 번째
 * 중복을 방지하는 백트레킹 문제.
 */
public class p15650 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[]arr = new int[m];
        DFS(0,n,0,m,arr);

        System.out.println(sb);

    }

    public static void DFS(int prev, int n, int level, int end, int[] arr) {
        if (level == end) {
            for(int k : arr)
                sb.append(k).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = prev+1; i <= n; i++) {
            arr[level]=i;
            DFS(i,n,level+1,end,arr);
        }


    }


}