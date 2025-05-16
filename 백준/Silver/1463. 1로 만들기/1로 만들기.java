import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[x + 1];
        final int INIT = 100_001;
        Arrays.fill(dp, INIT);
        dp[x] = 0;

        Queue<Integer> q = new ArrayDeque<>();

        q.add(x);
        int turn = 0;
        while(!q.isEmpty()) {
            turn++;
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();

                if (cur == 1) {
                    q.clear();
                    break;
                }

                if (cur % 3 == 0 && dp[cur / 3] > turn) {
                    dp[cur/3] = turn;
                    q.add(cur/3);
                }

                if (cur % 2 == 0 && dp[cur / 2] > turn) {
                    dp[cur/2] = turn;
                    q.add(cur/2);
                }

                if (dp[cur - 1] > turn) {
                    dp[cur-1] = turn;
                    q.add(cur - 1);
                }


            }
        }

        System.out.println(dp[1]);


    }




}
