package beak.binaryserach;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1654 {
    StringBuilder sb = new StringBuilder();


    public void solution() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        long[] arrays = new long[n];
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arrays[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arrays[i]);
        }
        System.out.println(paramSearch(arrays,r,max));

    }

    public long paramSearch(long[] arrays, int nOfRequired, long max){

        long l = 1L;
        long r = max;

        long maxLength = Long.MIN_VALUE;
        while (l <= r) {
            long mid = (l+r) >>> 1;
            long nOfLan = 0L;
            for (int i = 0; i < arrays.length; i++) {
                nOfLan += arrays[i]/mid;
            }



            if (nOfRequired > nOfLan) {
                r = mid - 1;
            } else {
                maxLength = Math.max(maxLength, mid);
                l = mid + 1;
            }
        }
        return maxLength;
    }



    public static void main(String[] args) throws Exception {
        new P1654().solution();
    }
}





