import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Bag[] bags = new Bag[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i] = new Bag(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(bags, new Comparator<Bag>() {
            @Override
            public int compare(Bag o1, Bag o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });


        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n ; i++) {
            Bag bag = bags[i-1];
            for (int j = 0; j <= k ; j++) {
                if (j >= bag.w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - bag.w] + bag.v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

   
        System.out.println(dp[n][k]);
    }

    static class Bag{
        int w;
        int v;

        public Bag(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }



}