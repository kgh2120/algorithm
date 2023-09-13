import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][] cost = {
            {1,2,2,2,2},
            {1,1,3,4,3},
            {1,3,1,3,4},
            {1,4,3,1,3},
            {1,3,4,3,1}
    };
    static int[][][]dp;
    static int[] command;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        command = new int[st.countTokens()];
        for (int i = 0; i < command.length; i++) {
            command[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[command.length][5][5];

        System.out.println(ddr(0,0,0));


    }

    private static int ddr(int depth, int left, int right){
        if(depth == command.length-1)
            return 0;

        if(dp[depth][left][right] != 0) return dp[depth][left][right];

        int next = command[depth];
//        dp[depth][left][right] = Math.min(ddr(depth+1, ))

        if (next == left || next == right) {
            dp[depth][left][right] = ddr(depth+1, left, right) + 1;
        } else{
            dp[depth][left][right] = Math.min(ddr(depth+1, next, right) + cost[left][next],
                    ddr(depth+1, left, next) + cost[right][next]);
        }
        return dp[depth][left][right];
    }
}