import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static StringTokenizer st;

    static int[] dp;

    static int[] original;
    static int[] mapped;
    static int n;


    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        dp = new int[n];
        original = new int[n];
        mapped = new int[n+1];

        st = new StringTokenizer(br.readLine());
        StringTokenizer stt = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            original[i] = Integer.parseInt(st.nextToken());
            int nm = Integer.parseInt(stt.nextToken());
            mapped[nm] = i;
        }

        Arrays.fill(dp,Integer.MAX_VALUE);

        int max = -1;
        for (int i = 0; i < n ; i++) {
            int num = mapped[original[i]];

            int index = Arrays.binarySearch(dp, num);
            if(index >= 0) continue;

            index = - (index + 1);

            if(dp[index] > num) dp[index] = num;
        }
//        System.out.println(Arrays.toString(dp));
        int i;
        for (i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                break;
            }
        }
        System.out.println(i);


    }






}