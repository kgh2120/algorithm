package beak.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11054_2 {

    int n;
    int [] arr;
    Integer[][] memo;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        memo = new Integer[n][2];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 0;
        while (st.hasMoreTokens())
            arr[idx++] = Integer.parseInt(st.nextToken());

        int max = -1;

        for (int i = 0; i < n; i++) {
            dpInc(i);
        }
        for (int i = 0; i < n; i++) {
            dpDec(i);
        }
        for (int i = 0; i < n; i++) {
            max = Math.max(max,Math.max(memo[i][0],memo[i][1]));
        }
        System.out.println(max);
    }

    public int dpInc(int i) {
        if (memo[i][0] == null) {
            memo[i][0] = 1;
            for (int j = 0; j < i; j++)
                if (arr[j] < arr[i])
                    memo[i][0] = Math.max(memo[i][0], dpInc(j)+1);
        }
        return memo[i][0];
    }
    public int dpDec(int i) {
        if (memo[i][1] == null) {
            memo[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {

                    memo[i][1] = Math.max(memo[i][1],Math.max(dpDec(j)+1, dpInc(j) + 1));
                }
            }
        }
        return memo[i][1];
    }


    public static void main(String[] args) throws Exception {
        new P11054_2().solution();
    }

}
