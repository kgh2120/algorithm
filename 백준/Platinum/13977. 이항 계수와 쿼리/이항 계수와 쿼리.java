import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, k;

    static final int MOD = 1_000_000_007;

    static long[] dp;

    static long factN, rFac, nmrFac;
    static int lastN;

    static int[][] powerDp;

    public static void main(String[] args) throws Exception {

        lastN = 1;
        dp = new long[4000001];
//        powerDp = new int[4000001][100];
        factN = 1;
        rFac = 1;
        nmrFac = 1;
        factorial();

        int TC = Integer.parseInt(br.readLine());
        for (int T = 1; T <= TC; T++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            if (k == 0 || n == k) {
                sb.append(1).append("\n");
                continue;
            }
            long left = power((dp[k] * dp[n - k]) % MOD, MOD - 2);
            sb.append(((dp[n]) * (left % MOD)) % MOD).append("\n");
        }
        System.out.println(sb);


    }

    private static void factorial() {
        dp[1] = 1;
        for (int i = 2; i <= 400_0000; i++) {
            dp[i] = dp[i - 1] * i % MOD;
        }
    }


    private static long power(long number, int n) {
        if (n == 1) return number;
//        if(powerDp[(int) number][(int) (Math.log(MOD) / Math.log(2))] != 0) return powerDp[(int) number][(int) ((int) (MOD) / Math.log(2))];

        long x = power(number, n / 2) % MOD;
        if (n % 2 == 0)
            return (x * x) % MOD;
        else
            return (((x * x) % MOD) * (number % MOD)) % MOD;

    }
}