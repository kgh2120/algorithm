package beak.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 각 N개에 들어갈 수 있는 00을 1개로 생각하고 총
 * N에서 빼고, 00이 들어갈 수 있는 경우를 계산함.
 * 그럼 각 케이스 별 N-i C i 가 나옴. i는 투입된 00의 개수
 * 처음엔 DP로 이항계수를 그려 넣었으나 메모리 초과가 발생.
 * 각 수의 관계를 다시 보니 피보나치와 같았음.
 * 피보나치로 변경해서 시도했는데 틀림.
 * % 연산을 안넣었음.
 * 이를 넣고 푸니 맞았음.
 */
public class p1904 {


    int[]m;
    public static void main(String []args) throws Exception {
        new p1904().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        m = new int[n+2];


        System.out.println(fibo(n+1));


    }


    public int fibo(int n) {

        m[1]=1;
        m[2]=1;
        for (int i = 3; i <=n ; i++) {
            m[i] = (m[i-1]+m[i-2])%15746;
        }
        return m[n];
    }





}