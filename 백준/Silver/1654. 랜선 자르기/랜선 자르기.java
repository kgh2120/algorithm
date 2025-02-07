import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            int val = Integer.parseInt(input.readLine());
            max = Math.max(max,val);
            arr[i] = val;
        }

        long left = 1;
        long right = max;

        long ans = -1;
        while(left <= right){
            long mid = (left+right)/2;

            long count = 0;
            for(int wood : arr){
                count += wood/mid;
            }
            // System.out.println(left + " " + right + " " + mid + " " + count);
            if (count >= k) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else right = mid - 1;

        }
        System.out.println(ans);
    }
}
