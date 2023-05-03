package beak.prev.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백트래킹 예제 4번 문제
 * 비내림차순을 적용한 정렬이라는데
 * 솔직히 잘 모르겠다.
 */
public class p15652 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[]arr = new int[m];
        DFS(1,n,0,m,arr);

        System.out.println(sb);

    }

    public static void DFS(int prev, int n, int level, int end, int[] arr) {
        if (level == end) {
            for(int k : arr)
                sb.append(k).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = prev; i <= n; i++) {
            arr[level]=i;
            DFS(i,n,level+1,end,arr);
        }


    }


}