package Inflearn.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백트레킹 예제 문제3
 * 중복 포함 나열하기.
 */
public class p15651 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[]arr = new int[m];
        DFS(n,0,m,arr);

        System.out.println(sb);

    }

    public static void DFS(int n, int level, int end, int[] arr) {
        if (level == end) {
            for(int k : arr)
                sb.append(k).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[level]=i;
            DFS(n,level+1,end,arr);
        }


    }


}