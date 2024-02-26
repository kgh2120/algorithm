import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final int INIT = -1;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static char[] left;
    static char[] right;
    static int[][] dp;

    public static void main(String[] args) throws Exception {

        left = br.readLine().toCharArray();
        right = br.readLine().toCharArray();
        dp = new int[left.length][right.length];

        for (int[] wrap : dp) {
            Arrays.fill(wrap,INIT);
        }
        lcs(left.length-1, right.length-1 );

        int max = -1;
        for (int[] wrap : dp) {
            for (int value : wrap) {
                max = Math.max(max,value);
            }
        }


        System.out.println(max);

    }

    static int lcs(int l, int r) {
        if(l < 0 || r < 0)
            return 0;
        if(dp[l][r] != INIT)
            return dp[l][r];

        lcs(l-1,r);
        lcs(l,r-1);

        if(left[l] == right[r]){
            return dp[l][r] = lcs(l-1,r-1) + 1;
        }

        return dp[l][r] =  0;
    }


}