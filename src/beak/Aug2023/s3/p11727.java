package beak.Aug2023.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
    @author 김규현
    @since 2023-08-03
    @see https://www.acmicpc.net/problem/11727
    @performance 19800kb , 104ms
    @category # 경우의 수
    @note
    2xn 사각형을 타일로 채우는 문제이다.
    사각형의 종류는 1x2, 2x1, 2x2 타일이 존재한다.
    일단 채울 수 있는 경우를 살펴보면, 세로로만 있는 사각형으로 다 채우는 것.
    그리고 2x2 타일에 (2x1 타일 2개 or 2x2) 타일을 사용하는 것으로 채울 수 있다.

    만약 2x2 방식을 쓰는 경우엔 n개의 칸에서 2칸을 사용한 만큼 n-a를 해주고,
    2칸 짜리가 들어갈 공간의 경우의 수를 살펴주면 될 것 같다.

    위의 경우에 대한 상황은 n-aCa 가 되는데, a에 위치에 2x1과 2x2가 들어갈 수 있는 상황임.\
    그렇기 때문에 n-aCa * 2^a 가 되어야 한다.

    n은 1000이고 시간은 1초 메모리는 256mb이다. 메모리의 경우엔 충분해보이고.
    조합의 수를 매번 구하는 것은 어렵기 때문에 dp를 이용해 구해놓고 다시 사용하는 것이 좋아 보인다.

    사용할 변수 목록
    입출력 : BufferedReader
    변수 : n (크기)
    DP테이블 : int[][]memo;
    나머지 변수 : MOD = 10_007
*/
public class p11727 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static long[][] memo;
    static final long MOD = 10_007;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        memo = new long[n+1][n+1];
        long result = 1;
        for (int i = 1; i <= n / 2; i++) {
            result += (comb(n-i,i) % MOD * pow(i)% MOD) % MOD;
        }
        System.out.println(result%MOD);
    }

    private static long pow(int i){
        long rtVal = 1;
        for (int j = 0; j < i; j++) {
            rtVal = (rtVal * 2)%MOD;
        }
        return rtVal;
    }



    private static long comb(int n, int r){
        if(memo[n][r] != 0)
            return memo[n][r] % MOD;
        if(n==r || r == 0)
            return 1;
        return memo[n][r] = (comb(n-1,r-1) % MOD + comb(n-1,r) % MOD) % MOD;
    }

}
