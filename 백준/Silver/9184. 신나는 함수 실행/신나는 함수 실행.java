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

    static int[][][] dp;
    public static void main(String[] args) throws Exception {
        dp = new int[21][21][21];
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1)
                break;
            int result = w(a,b,c);
            output(a,b,c,result);
        }
        System.out.println(sb);

    }

    static int w(int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0) return 1;

        if(a > 20 || b > 20 || c > 20) return w(20,20,20);

        if(dp[a][b][c] != 0) return dp[a][b][c];

        if (a < b && b < c) {
            return dp[a][b][c] = w(a,b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        } else {
            return dp[a][b][c] =  w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }
    }
    static void output(int a, int b, int c, int result){
        sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(result).append("\n");
    }


}