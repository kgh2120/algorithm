import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    Integer[][] memo;
    int[][] bag;

    public void solution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        bag = new int[n][w+1];
        memo = new Integer[n][w+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            bag[i][0] = Integer.parseInt(st.nextToken()); // w
            bag[i][1] = Integer.parseInt(st.nextToken()); // p
        }
        dp(n-1,w);
        System.out.println(memo[n-1][w]);
    }

    public int dp(int i, int w) {
        if(i < 0 || w < 0)
            return 0;

        if (memo[i][w] == null) {

            if(w-bag[i][0] < 0)
                memo[i][w] =  dp(i-1,w);
            else
                memo[i][w] = Math.max(bag[i][1] + dp(i-1,w-bag[i][0]), dp(i-1,w));
        }
        return memo[i][w];
    }





    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}
