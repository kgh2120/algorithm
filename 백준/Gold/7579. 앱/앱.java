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

            int [] memory = new int[n];
            int [] cost = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int [] dp = new int[m+1];
        Arrays.fill(dp, 100_0000);
        dp[0] = 0;
        // 뒤에서부터 진행

        for (int i = 0; i < n; i++) {
            for (int j = m; j > 0; j--) {
                int next = Math.max(j - memory[i], 0);
                dp[j] = Math.min(dp[j], dp[next] + cost[i]);
            }
        }
        System.out.println(dp[m]);


    }



}