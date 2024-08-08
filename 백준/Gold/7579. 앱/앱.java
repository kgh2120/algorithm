import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


/*
    @제약사항 :
    @입력 범위 :
    @문제 내용 :
    @주의 사항 :
    @예상 알고리즘 :
*/
public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] memory = new int[n];
        int[] cost = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[10001];

        dp[0] = 0;
        // 뒤에서부터 진행
        for (int i = 0; i < n; i++) {
            for (int j = 10000; j >= 0; j--) {
                if (cost[i] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
                }
            }
        }

        for (int i = 0; i <= 10000; i++) {
            if (dp[i] >= m) {
                System.out.println(i);
                break;
            }

        }

    }


}