import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;



    static int n;
    static int [] price;
    static int [] dp;

    static final int CLEAR = 10_0000_0000;

    public static void main(String[] args) throws Exception {

        n = Integer.parseInt(br.readLine());
        price = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dp(0) - CLEAR);
    }

    static int dp(int number) {
        if (number > n) {
            return 0;
        }

        if (number == n) {
            return CLEAR;
        }

        if (dp[number] > CLEAR) {
            return dp[number];
        }

        for (int i = 0; i < n; i++) {
            dp[number] = Math.max(dp[number], dp(number + (i+1) )+ price[i]);
        }
        return  dp[number];
    }

}