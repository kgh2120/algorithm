import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());

        int [] dists = new int[n-1];
        int[] prices = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            dists[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        long totalPrice = 0L;

        for (int index = 0; index < n; ) {

            // 1. 나(index)보다 싼 애를 찾는다.
            int next = index+1;
            long dist = 0;
            while (next < n) {

                dist += dists[next-1];

                if (prices[next] < prices[index]) {
                    break;
                }
                next++;
            }
            totalPrice += dist * prices[index];
            index = next;
        }

        System.out.println(totalPrice);
    }
}