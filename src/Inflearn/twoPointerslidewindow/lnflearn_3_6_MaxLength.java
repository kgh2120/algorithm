package Inflearn.twoPointerslidewindow;

import java.util.Arrays;
import java.util.Scanner;

public class lnflearn_3_6_MaxLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nOfNum = sc.nextInt();
        int chance = sc.nextInt();
        int[] arr = new int[nOfNum];
        for (int i = 0; i < nOfNum; i++) {
            arr[i] = sc.nextInt();
        }

        int[] zeroArr = new int[chance];
        Arrays.fill(zeroArr,-1);

        int l = 0;
        int r = 0;
        int len = 0;
        int max = 0;
        int zero = 0;

        for (int i = 0; i < nOfNum; i++) {
            int now = arr[i];
            if (now == 0) {
                if (zero == chance) { // 바꿔야 한다
                    l = swap(zeroArr, i);
                }else{
                    zeroArr[zero] = i;
                    zero++;
                }
            }
            len = i-l+1;
            max = Math.max(max, len);
        }

        System.out.println(max);

    }


    public static int swap(int[] arr, int r) {
        int l = arr[0] + 1;
        for (int i = 1; i <arr.length ; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = r;
        return l;
    }
}
