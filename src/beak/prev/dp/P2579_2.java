package beak.prev.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2579_2 {

    int[]array;
    int[]memo;
    int n;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n  =  Integer.parseInt(br.readLine());

        array = new int[n];
        memo = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        memo[0] = array[0];
        getMaxValue();
    }

    public void getMaxValue(){
        if (n < 2) {
            System.out.println(array[0]);
            return;
        }


        int max = Math.max(array[n-2] + dp(n-4), dp(n-3));
        System.out.println(max + array[n-1]);
    }


    public int dp(int n) {
        if(n<0)
            return 0;
        if(memo[n]!=0)
            return memo[n];

        return memo[n] = array[n] + Math.max(array[n-1] + dp(n-3), dp(n-2));
    }

    public static void main(String[] args) throws Exception {
        new P2579_2().solution();
    }

}
