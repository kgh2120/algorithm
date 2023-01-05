package beak.greedy;

import com.sun.tools.javac.Main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11305 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dists = new int[n-1];
        int[] prices = new int[n-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = 0;
        while (d != n-1) {
            dists[d++] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int p = 0;
        while (p != n-1) {
            prices[p++] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        int prev = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            long k = 0;
            if(prices[i] >= prev)
                continue;
            k += (long) prices[i] * dists[i];

            // loop 내 다음으로 나보다 비싸면 내꺼로 산다.

                for (int j = i + 1; j < n - 1; j++) {

                    if (prices[i] > prices[j]) {
                        break;
                    }
                    k += (long) prices[i] * dists[j];
                }

            sum += k;
            prev = prices[i];
        }

        System.out.println(sum);

    }




    public static void main(String []args) throws Exception {
        new P11305().solution();
    }
}





