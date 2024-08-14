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
        int n  = Integer.parseInt(input.readLine());

        boolean [] dp = new boolean[40001];

        st = new StringTokenizer(input.readLine());
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int weight = Integer.parseInt(st.nextToken());

            for (int j = 40000 - weight; j >=0; j--) {
                if(dp[j])
                    dp[j+weight] = true;
            }
            for (int j = 0; j <= 40000; j++) {
                if(dp[j])
                    dp[ Math.abs(j-weight)] = true;
            }

        }

        int k = Integer.parseInt(input.readLine());
        st = new StringTokenizer(input.readLine());

        for (int i = 0; i < k; i++) {
            int t = Integer.parseInt(st.nextToken());
            String ans = dp[t] ? "Y " : "N " ;
            output.append(ans);
        }
        System.out.println(output);


    }
}