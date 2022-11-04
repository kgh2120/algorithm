package beak.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 각 숫자의 경우의 수를 구하는 부분 집합을 쉽게 찾았지만, %연산 위치를 헷갈려서
 * 좀 더 걸린듯.
 * 근데 점화식으로 규칙을 찾아서 푸는 사람들도 있던데, 그게 더 쉬웠던 거 같다.
 */
public class p10844 {

    long[][]m;
    int n;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = new long[n+1][10];
        for (int i = 0; i <10 ; i++) {
            m[1][i]=1;
        }


        for (int i = 0; i < 10; i++) {
            r(n, i);
        }
        long result = 0;

        for (int i = 1; i < 10; i++) {
            long r = m[n][i];
            result += r;
        }
        System.out.println(result%1000000000);
    }


    public long r(int n, int col) {
        if(m[n][col]!=0)
            return m[n][col]%1000000000;

        if(col == 0)
            m[n][col] = r(n-1,col+1);
        else if(col==9)
            m[n][col] = r(n-1,col-1);
        else
            m[n][col] = r(n-1,col-1) + r(n-1,col+1);

        return m[n][col];

    }

    public static void main(String []args) throws Exception {
        new p10844().solution();
    }
}





