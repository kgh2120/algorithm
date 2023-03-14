import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {


    int[]memo;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            memo = new int[k+1];
            sb.append(dp(k)).append("\n");
        }
        System.out.println(sb);
    }

    public int dp(int k) {
        if(memo[k]!=0)
            return memo[k];
        if (k <= 3) {
            if(memo[k]==0)
                memo[k] = 1;
            return memo[k];
        }
        return memo[k] = dp(k-2) +dp(k-3);
    }


    public static void main(String[] args) throws Exception {
        new Main2().solution();
    }

}
