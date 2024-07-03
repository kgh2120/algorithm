import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {




    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            arr[i] = number;

        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        int l = 0;
        int r = 0;

        while (l <= r && r < n) {
            int diff = Math.abs(arr[r] - arr[l]);
            if (diff >= m) {
                min = Math.min(min, diff);
                l++;
            }else
                r++;
        }
        System.out.println(min);


    }




}