import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * - @author 규현
 * - @since 2024-03-03
 * - @limit memory : 4mb time : 0.5ms
 * - @performance
 * - @category #DP
 * - @note
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[k + 1];
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int number= Integer.parseInt(br.readLine());
            if(number <= k)
                numbers.add(number);
        }

        Collections.sort(numbers, Collections.reverseOrder());


        for (Integer number : numbers) {
            arr[number]++;
            for (int i = number; i <= k ; i++) {
                arr[i] += arr[i-number];
            }
        }

        System.out.println(arr[k]);


    }




}