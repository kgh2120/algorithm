import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
    @author 김규현
    @since 2023-08-16
    @see https://www.acmicpc.net/problem/1920
    @note

    주어진 수열 A 에서 그 이후 주어진 숫자들이 존재하는 지 체크를 하는 문제이다.
    A과 M이 100,000이고 시간 제한이 1초이다.
    N^2은 불가능 하기 때문에, 순차 탐색은 어려울 것이다.
    바이너리 서치를 이용하라고 했으니 그걸 할 것이고, 그렇지 않다 하더라도 여러 방법으로 시도해봐야겠다.
*/
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] A; // 주어진 수열 A를 받을 배열
    static int a, m;
    public static void main(String[] args) throws IOException {
        // 변수 설정
        setVaribles();
        Arrays.sort(A); // 2진탐색을 위한 정렬 n log n
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(st.nextToken());
            sb.append(Arrays.binarySearch(A,number)>=0 ? "1\n" : "0\n");
        }
        System.out.println(sb);
    }
//    public static void main(String[] args) throws IOException {
//        // 변수 설정
//        setVaribles();
//        Arrays.sort(A); // 2진탐색을 위한 정렬 n log n
//        for (int i = 0; i < m; i++) {
//            int number = Integer.parseInt(st.nextToken());
//            sb.append(binarySearch(number) ? "1\n" : "0\n");
//        }
//        System.out.println(sb);
//    }

    private static boolean binarySearch(int n) {
        int l = 0;
        int r = a-1;
        while (l <= r) {
            int midIdx = (r+l)/2;
            int mid = A[midIdx];
            if (mid < n) {
                l = midIdx+1;
            } else if (mid > n) {
                r = midIdx-1;
            }else{
                return true;
            }
        }
        return false;
    }





    private static void setVaribles() throws IOException {
        a = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = new int[a];
        for (int i = 0; i < a; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());


    }

}