import java.io.BufferedReader;
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

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[100 + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= 100 ; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }

        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(br.readLine());
            sb.append(dp[index]).append("\n");
        }
        System.out.println(sb);

    }


}