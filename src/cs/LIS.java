package cs;

import java.util.Arrays;

public class LIS {

    public static void main(String[] args) {
        int [] arr = {10,20,10,30,40};

        int[] lis = new int[arr.length];
        Arrays.fill(lis,Integer.MAX_VALUE);
        lis[0] = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int idx = Arrays.binarySearch(lis, arr[i]);
            if(idx >= 0) {
                continue;
            }
            int k = -(idx+1);
            if(lis[k] > arr[i]) lis[k] = arr[i];
        }
        System.out.println(Arrays.toString(lis));
        int count = 0;
        for (int li : lis) {
            if(li == Integer.MAX_VALUE)
                break;
            count++;
        }
        System.out.println(count);
    }

}
