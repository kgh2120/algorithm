package beak.prev.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * DP인데 Sliding Window 기법으로 해결한 문제.
 * 어떤 식으로 DP로 풀었는지는 찾아봐야 알 거 같다.
 * 이번엔 반복문을 종료하는 조건문의 위치를 잘못두었어서 틀렸었다.
 * 이는 가장 마지막 숫자로 인해서 최대값이 결정되는 순간에 관련한 것이었음.
 * 또 int형을 넘어서는 크기가 나올 수 있다는 사실을 생각했어야 했음.
 * 항상 극한의 상황에서 나올 수 있는 반례를 고려하면서 문제를 풀어야 한다.
 */
public class p1912 {


    int l=0;
    int r=1;
    long c;
    long max = Long.MIN_VALUE;
    long[]m;
    public static void main(String []args) throws Exception {
        new p1912().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        m = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            m[i]=k;
        }

        slidingWindows();



    }

    public void slidingWindows() {
        c = m[0];

        while (true) {
            max = Math.max(c,max);


            if(r==m.length)
                break;
            long next = m[r];

            if (c + next < next) {
                l = r;
                c=next;
            }else
                c += next;

            r++;

        }
        System.out.println(max);
    }





}