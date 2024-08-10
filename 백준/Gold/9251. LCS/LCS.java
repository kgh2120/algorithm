import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder output = new StringBuilder();


    static char[] a;
    static char[] b;
    static int[][] dp;

    public static void main(String[] args) throws Exception {

         a = input.readLine().toCharArray();
         b = input.readLine().toCharArray();
        dp = new int[a.length][b.length];

        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }

        System.out.println(lcs(a.length-1, b.length-1));


    }

    static int lcs(int left, int right) {

        if(left == -1 || right == -1) return 0;

        if(dp[left][right] != -1) return dp[left][right];

        if(a[left] == b[right]) return dp[left][right] = lcs(left-1, right-1) + 1;
        return dp[left][right] = Math.max(lcs(left-1,right), lcs(left,right-1));
    }
}