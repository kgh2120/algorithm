package beak.binaryserach;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2805 {
    StringBuilder sb = new StringBuilder();


    public void solution() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        long[] arrays = new long[n];
        long max = Long.MIN_VALUE;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arrays[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, arrays[i]);
        }
        System.out.println(paramSearch(arrays,r,max));

    }

    public long paramSearch(long[] arrays, int requiredLength, long max){

        long l = 0L;
        long r = max;
        long maxLength = Long.MIN_VALUE;
        while (l <= r) {

            long mid = (l+r) >>> 1;
            long totalLength = 0;
            for (long array : arrays) {
                long length = array - mid;
                length = length < 0 ? 0 : length;
                totalLength += length;
            }

            if (requiredLength > totalLength) {
                r = mid -1;
            } else {
                maxLength = Math.max(maxLength,mid);
                l = mid +1;
            }
        }
        return maxLength;
    }



    public static void main(String[] args) throws Exception {
        new P2805().solution();
    }
}





