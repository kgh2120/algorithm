import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    12869 뮤탈

    뮤탈은 9 3 1 씩 데미지를 준다.

    SCV는 1 ~ 3개가 있다.

    가장 최소로 hit해서 전부 터트릴 수 있는 횟수를 찾아라.

    scv의 체력은 60이하이다.

    scv를 때리는 서순을 본다면 한 턴에 경우는 6가지가 발생한다 (scv가 3개라는 경우에서)
     -> 1 2 3 / 1 3 2 / 2 1 3/ 2 3 1 / 3 1 2 / 3 2 1

    3쿠션이 안터져서 9씩만 들어가는 상황에서 60 60 60이라고 하면 7 7 7대로 총 21대가 소모된다.
    그럼 경우를 대충 나누면 6 ^ 21이다. 6 ^ 10 -> 2 ^ 10 * 3 ^10 인데 2 ^ 10 은 1024다. 3^ 10은 6만정도이다.
    6 ^ 10은 그럼 10 ^ 7정도? 그럼 6 ^ 20은 10 ^ 14니까 큰일났다.



 */
class Main {


    public static final int INIT = -1;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][][] dp;

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] temp = new int[3];
        for (int i = 0; i < n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(temp);

        dp = new int[temp[0]+1][temp[1]+1][temp[2]+1];

        for (int[][] dd : dp) {
            for (int[] ints : dd) {
                Arrays.fill(ints, INIT);
            }
        }

        System.out.println(dp(temp));


    }

    private static int dp(int [] arr){
        if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
            return 0;
        }
        if (dp[arr[0]][arr[1]][arr[2]] != INIT) {
            return dp[arr[0]][arr[1]][arr[2]];
        }

        // 6개의 경우의수 중 가장 짧은 애 등록

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if(j == i) continue;
                for (int k = 0; k <= 2; k++) {
                    if(k == j || k == i) continue;
                    int[] temp = {minus(arr[i], 9), minus(arr[j],3), minus(arr[k],1)};
                    Arrays.sort(temp);
                    min = Math.min(min, dp(temp));

                }
            }
        }

        return dp[arr[0]][arr[1]][arr[2]]  = 1 + min;
    }

    private static int minus(int number, int degree) {
        return Math.max(0, number - degree);
    }

}