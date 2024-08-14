import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder output = new StringBuilder();

    static   int[][] dp ;
    static  int[][] arr;
    static int n;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(input.readLine());
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr[i][0] = f;
            arr[i][1] = t;
        }

        dp = new int[n][n];

        int i = find(0, n - 1);
        System.out.println(i);




    }

    static int find(int left, int right) {

        if(dp[left][right] != 0)
            return dp[left][right];
        if(left == right)
            return 0;

        if (left + 1 == right) {
            return dp[left][right] = arr[left][0] * arr[right][0] * arr[right][1];
        }

        int min = Integer.MAX_VALUE;
        
        for (int i = left; i < right ; i++) {
            // left ~ i ,, i ~ right 그리고 arr[left][0] * arr[i][1] * arr[right][1]
            min = Math.min(min, find(left,i) + find(i+1, right) + arr[left][0] * arr[i][1] * arr[right][1]);
        }
        return dp[left][right] = min;
    }
}