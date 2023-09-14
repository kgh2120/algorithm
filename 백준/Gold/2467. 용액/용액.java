import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static int[] arr;
    static int min = Integer.MAX_VALUE;
    static int minLeft;
    static int minRight;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = n-1;
        while (l < r) {
            int left = arr[l];
            int right = arr[r];
            int abs = Math.abs(left+right);
            if (min >= abs) {
                minLeft = left;
                minRight = right;
                min = abs;
            }

            int absL = Math.abs(left);
            int absR = Math.abs(right);
            if(absL > absR){
                l++;
            }else
                r--;
        }
        sb.append(minLeft).append(" ")
                .append(minRight);
        System.out.println(sb);

    }



}