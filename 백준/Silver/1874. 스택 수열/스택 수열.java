import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
    @author 김규현
    @since 2023-08-11
    @see
    @git
    @youtube
    @performance
    @category #
    @note 
*/
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int num = 1;
        int idx = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> d = new ArrayDeque<>();
//        System.out.println(1 == d.peekFirst());
        while (num <= n+1 && idx < n) {
            // 같은 경우
            if (d.isEmpty()) {
                d.addFirst(num++);
                append("+");
                continue;
            }

            if (arr[idx] == d.peekFirst()) {
                d.pollFirst();
                append("-");
                idx++;
                continue;
            }
            // 다른 경우
            if (arr[idx] != d.peekFirst()) {
                d.addFirst(num++);
                append("+");
                continue;
            }
        }
        if (idx < n) {
            System.out.println("NO");
        }else
            System.out.println(sb);


    }
    private static void append(String s){
        sb.append(s).append("\n");
    }



}