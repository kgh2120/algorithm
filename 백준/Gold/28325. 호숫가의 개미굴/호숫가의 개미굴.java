import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


/**

    @author 규현
    @since 2023-09-29
    @url https://www.acmicpc.net/problem/1400
    @level G2
    @try 1
    @performance 11852KB, 88ms
    @category #구현 #그래프 이론 #그래프 탐색 #다익스트라(??)
    @note

    BFS문제에서 신호등이 생겼다.
    신호등때문에 해당 방향이 아니라면, 대기를 해야 하는 케이스가 발생함.

    핵심은 신호등을 어떻게 구현할지를 생각해야함.

    신호등은 인덱스, 시작 방향, 동-서 시간, 남-북 시간을 가진다.

    신호등의 개수는 총 20개가 끝이고, 전체 매트릭스의 크기도 20*20이기 때문에,

    신호등이 현재 어느 방향을 가르키고 있는지를 매 시간이 지날 때, 연산을 통해서 진행하고, 상하는  0,1 좌우는 2,3 델타를 쓰는 걸로
    방향 체크를 하면 될 듯 싶다.

    그래서 이동이 가능하면 nr,nc로 이동한 애를 큐에 넣어주고
    이동 못하면 이동은 못하고 걍 넣어주는 걸로

*/
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static long[] arr;
    static long[][][] dp;
    static final long INIT = -1;

    public static void main(String[] args) throws Exception {
        setVariables();
        System.out.println(dp(0,0,0));
//        System.out.println(Arrays.deepToString(dp));
    }

    private static long dp(int depth, int isFirstSelected, int selected) {
        if(depth > n) return 0;
        if (depth == n) {
            if(isFirstSelected == 0 && selected == 1)
                return 1;
            else
                return arr[depth];

        }

        if(dp[isFirstSelected][selected][depth] != INIT) return dp[isFirstSelected][selected][depth];
        if (depth == 0) {
            return dp[isFirstSelected][selected][depth] = Math.max(dp(1, 1,1), dp(1,0,0));
        }


        if (selected == 0) {
            dp[isFirstSelected][selected][depth] = Math.max(dp(depth+1, isFirstSelected, 0), dp(depth+1,isFirstSelected,1)) + arr[depth];
        }else{
            dp[isFirstSelected][selected][depth] = dp(depth+1,isFirstSelected,0)+ 1;
        }
        return dp[isFirstSelected][selected][depth];
    }

    private static void setVariables() throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new long[n+1];
        dp = new long[2][2][n+1];
        for (long[][] ints : dp) {
            for (long[]d : ints) {
                Arrays.fill(d,INIT);
            }
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
    }
}