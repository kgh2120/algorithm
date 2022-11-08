package beak.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11054 {



    int[] arr;
    Integer[] dpR;
    Integer []dpL;
    int [] max;
    int end;
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        end = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[end];
        dpR = new Integer[end];
        dpL = new Integer[end];
        max = new int[end];

        for (int i = 0; i < end; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(r());


    }

    public int r() {

        int m = Integer.MIN_VALUE;

        for (int i = 0; i < end; i++) {
            m = Math.max(rr(i) + rl(i),m);
        }

        return m+1;
    }

    public int rr(int n) {

        if (dpR[n] == null) {
            dpR[n] = 0;
            for (int i = n+1; i < end; i++) {
                if(arr[n]>arr[i])
                    dpR[n] = Math.max(dpR[n],1+rr(i));
            }
        }

        return dpR[n];
    }

    public int rl(int n) {

        if (dpL[n] == null) {
            dpL[n]=0;
            for (int i = n-1; i >= 0 ; i--) {
                if(arr[n]>arr[i])
                    dpL[n] = Math.max(dpL[n],1+rl(i));
            }
        }

        return dpL[n];
    }









    public static void main(String []args) throws Exception {
        new p11054().solution();
    }
}





