import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static StringTokenizer st;

    static int[][][] dp;

    static String left;
    static String mid;
    static String right;


    public static void main(String[] args) throws Exception {

        left = br.readLine();
        mid = br.readLine();
        right = br.readLine();

        dp = new int[left.length()][mid.length()][right.length()];

        for (int[][] memo : dp) {
            for (int[] me : memo) {
                Arrays.fill(me,-1);
            }
        }

        int result = LCS(left.length() - 1, mid.length() - 1, right.length() - 1);
        System.out.println(result);
    }


    private static int LCS(int l, int m, int r) {
        if(l < 0 || m < 0 || r < 0) return 0;

        if(dp[l][m][r] != -1) return dp[l][m][r];
        if (left.charAt(l) == mid.charAt(m) && mid.charAt(m) == right.charAt(r)) {
            dp[l][m][r] = LCS(l-1,m-1,r-1) + 1;
        }else{
            dp[l][m][r] = Math.max(LCS(l-1,m,r), Math.max(LCS(l,m-1,r), LCS(l,m,r-1)));
        }
        return dp[l][m][r];
    }




}