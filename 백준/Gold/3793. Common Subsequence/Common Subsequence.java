import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/*
    @제약사항 : 1초, 128mb
    @입력 범위 : 각 문자열은 길이가 200자를 넘지 않음. TC가 몇개인지는 알 수 없음.
    @문제 내용 : 그냥 각 line에 있는 왼쪽 문자열과 오른쪽 문자열의 최장 공통 부분 수열의 길이를 구하는 문제
    @주의 사항 : 딱히 없음.
    @예상 알고리즘 : DP, LCS
*/
public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static char[][] matrix;
    static int[][] dp;


    public static void main(String[] args) throws Exception {
        String str;
        while((str = br.readLine()) != null) {

            st = new StringTokenizer(str);
            matrix = new char[2][];
            int index = 0;
            while (st.hasMoreElements()) {
                matrix[index++] = st.nextToken().toCharArray();
            }
            if (index == 1) {
                st = new StringTokenizer(br.readLine());
                matrix[index] = st.nextToken().toCharArray();
            }
            dp = new int[matrix[0].length][matrix[1].length];
            for (int[] ints : dp) {
                Arrays.fill(ints,-1);
            }

            int answer = lcs(matrix[0].length - 1, matrix[1].length - 1);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);







    }

    static int lcs(int left, int right){

        if(left < 0 || right < 0) return 0;

        if(dp[left][right] != -1) return dp[left][right];

        if (matrix[0][left] == matrix[1][right]) {
            return dp[left][right] = lcs(left-1,right-1) + 1;
        } else {
            return dp[left][right] = Math.max(lcs(left-1,right), lcs(left,right-1));
        }
    }




}