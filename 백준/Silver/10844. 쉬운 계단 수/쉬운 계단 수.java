import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Main {



    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder output = new StringBuilder();


    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(input.readLine());
        int[][]dp = new int[n+1][10];
        dp[0][0]=0;
        for (int i = 1; i <10 ; i++) {
            dp[0][i] = 1;
        }
        int mod = 10_0000_0000;
        for (int i = 1; i <=n ; i++) {
            dp[i][0] = (dp[i-1][1]);
            dp[i][9] = (dp[i-1][8]);
            for (int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
            }
        }

        int ans = 0;
        for (int i : dp[n-1]) {
            ans += i;
            ans %= mod;
        }




        System.out.println(ans);




    }



}