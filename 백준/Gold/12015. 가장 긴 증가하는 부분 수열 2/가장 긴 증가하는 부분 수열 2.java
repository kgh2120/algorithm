import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static StringTokenizer st;


    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] lis = new int[n];
        Arrays.fill(lis, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        lis[0] = arr[0];

        for (int i = 0; i < n; i++) {
            int index = Arrays.binarySearch(lis, arr[i]);
            if(index >= 0) continue;
            index = - (index+1);
            if(lis[index] > arr[i]) lis[index] = arr[i];

        }

        int i;
        for (i = 0; i < n; i++) {
            if (lis[i] == Integer.MAX_VALUE) {
                break;
            }
        }
        System.out.println(i);


    }


}