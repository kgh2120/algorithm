import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - @author 규현
 * - @since 2024-03-06
 * - @limit memory : 1024mb time : 1s
 * - @performance
 * - @category #parametic search
 * - @note
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long c = Long.parseLong(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());


        long y = (a + c) / d;
        if ((a + c) % d != 0)
            y++;

        if (k == 0) {
            long x = (a) / b;
            if(a%b != 0)
                x++;
            System.out.println(x >= y ? -1 : x);
            return;
        }


        long maxN = b / k;
        if (b % k != 0)
            maxN++;
        long minN = 0;


        if (sum(b,-k, maxN) < a) {
            System.out.println(-1);
            return;
        }

        long minX = a;

        while (minN < maxN) {
            long mid = (minN + maxN) / 2;
            if(mid == minN || mid == maxN) break;
            long sum = sum(b, -k, mid);

            if (sum < a) {
                minN = mid;
            }else{
                if (minX > mid) {
                    minX = mid;
                } else if (minX == mid) {
                    break;
                }
                maxN = mid;
            }
        }

        if(minX >= y)
            System.out.println(-1);
        else
            System.out.println(minX);


    }

    static long sum(int b, int k, long n) {
        return (n * ( 2*b + (n-1) * k)) / 2;
    }


}