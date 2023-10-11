import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n,k;

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (k == 0 || n == k) {
            System.out.println(1);
            return;
        }

        long factN = 1;
        long rFac = 1;
        long nmrFac = 1;
        for (int i = 1; i <= n ; i++) {
            factN *= i;
            factN %= MOD;
            if(i == k)
                rFac = factN;
            if(i == n-k)
                nmrFac = factN;
        }
        long left = power((rFac )%MOD, MOD - 2);
        long right = power((nmrFac)%MOD, MOD - 2);
        long f = ((left % MOD) * (right % MOD)) % MOD;
        System.out.println(((factN) * (f % MOD))%MOD);
    }



    private static long power(long number, int n){
        if(n == 1) return number;
        else {
            long x = power(number, n / 2) % MOD;
            if (n % 2 == 0)
                return  (x * x) % MOD;
            else
                return (((x * x) % MOD) * (number % MOD))% MOD;
        }
    }
}