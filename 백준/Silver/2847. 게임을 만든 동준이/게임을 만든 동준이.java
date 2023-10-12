import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int prev = arr[n-1];
        int result = 0;
        for (int i = n-2; i >= 0 ; i--) {
            if (arr[i] >= prev) {
                result += arr[i] - (prev-1);
                prev = prev-1;
            }else
                prev = arr[i];
        }
        System.out.println(result);
    }
}