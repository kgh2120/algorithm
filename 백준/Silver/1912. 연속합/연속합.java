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


    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int cur = 0;

        for (int i : arr) {
            cur += i;

            max = Math.max(max, cur);
            if (cur < 0) cur = 0;
        }
        System.out.println(max);

    }


}