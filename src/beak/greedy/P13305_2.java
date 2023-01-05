package beak.greedy;

import com.sun.tools.javac.Main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13305_2 {

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dists = new int[n-1];
        Integer[] prices = new Integer[n-1];

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

        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i+1] > prices[i])
                prices[i+1] = prices[i];
        }
        
        long sum = 0;
        int c = 0;
        for (Integer price : prices) {
            sum += (long) price * dists[c++];
        }
        System.out.println(sum);



    }




    public static void main(String []args) throws Exception {
        new P13305_2().solution();
    }
}





