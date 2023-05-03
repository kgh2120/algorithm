package beak.prev.binaryserach;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1300 {
    StringBuilder sb = new StringBuilder();


    public void solution() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      long c = Long.parseLong(br.readLine());


      long l = 1;
      long r = (long) n *n;
      long min = Long.MAX_VALUE;
        while (l <= r) {
            long mid = (l+r) >>> 1;

            long k = 0;
            for (long i = 1; i <= n; i++) {
                k += Math.min(mid / i,n);
            }

            if(k < c)
                l = mid+1;
            else{
               min = Math.min(min, mid);
                r = mid - 1;
            }


        }
        System.out.println(min);
    }

    public static void main(String[] args) throws Exception {
        new P1300().solution();
    }
}





