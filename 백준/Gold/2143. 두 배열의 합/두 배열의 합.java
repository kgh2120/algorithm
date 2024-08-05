import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;



/*
    @제약사항 : 2초 64mb
    @입력 범위 : n <= 1000 , T <= | 10억 | , 각 원소값 <= | 100만 |
    @문제 내용 :
        T와 배열 A, 배열 B가 주어질 때, 배열 A의 i~j까지의 모든 합과 배열 B의 i ~ j 까지의 모든 합을 통해 T를 만들 수 있는
        경우의 수를 구하시오.
    @주의 사항 : 메모리가 겁나 작은데, 메모리 계산이 잘 안된다.
    @예상 알고리즘 : 누적합, 해싱?
*/
public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {

        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int v = Integer.parseInt(st.nextToken());
            arrA[i] = v + arrA[i-1];
        }
        int m = Integer.parseInt(br.readLine());
        int [] arrB = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            int v = Integer.parseInt(st.nextToken());
            arrB[i] = v + arrB[i-1];
        }

        Map<Integer, Counter> counters = new HashMap<>(1000000);
        for (int i = m; i > 0 ; i--) {
            for (int j = i-1; j >= 0 ; j--) {
                int value = arrB[i] - arrB[j];

                Counter counter = counters.get(value);
                if (counter == null) {
                    counter = new Counter();
                    counters.put(value, counter);
                }
                counter.count++;
            }
        }

        long answer = 0;
        // A의 누적합 계산하면서 counter 꺼내서 값 구하기

        for (int i = n; i > 0 ; i--) {
            for (int j = i-1; j >= 0 ; j--) {
                int value = arrA[i] - arrA[j];
                int opp = t - value;


                Counter counter = counters.get(opp);
                if (counter != null) {
                    int count = counters.get(opp).count;
                    answer += count;
                }
            }
        }

        System.out.println(answer);

    }

    static class Counter{
        int count;


    }

}