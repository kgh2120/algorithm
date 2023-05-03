package beak.prev.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1912_2 {


    long max = Long.MIN_VALUE;

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }
        chainSum(arr);
        System.out.println(max);
    }

    public void chainSum(int[]arr){

        long cur = -1001;
        for (int i = 0; i < arr.length; i++) {
            cur = Math.max(cur + arr[i],arr[i]);
            max = Math.max(cur,max);
        }

    }



    public static void main(String[] args) throws Exception {
        new P1912_2().solution();
    }

}
