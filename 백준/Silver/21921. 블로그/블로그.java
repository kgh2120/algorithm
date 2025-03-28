import java.io.*;
import java.util.*;



public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = 0;
        int cur = 0;
        int max = 0;
        int maxN = 0;
        while(l <= r && r <= n){

            if (r - l ==  x) {
                if (max < cur) {
                    max = cur;
                    maxN = 1;
                } else if (max == cur) {
                    maxN++;
                }
                cur -= arr[l++];
            }
            if(r == n)
                break;
            
            cur += arr[r++];
        }

        StringBuilder answer = new StringBuilder();
        if (max == 0) {
            answer.append("SAD");
        }else {
            answer.append(max).append("\n").append(maxN);
        }


        System.out.println(answer);

    }

}
