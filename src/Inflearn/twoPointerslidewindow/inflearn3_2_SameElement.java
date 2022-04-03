package Inflearn.twoPointerslidewindow;

import java.util.Arrays;
import java.util.Scanner;



public class inflearn3_2_SameElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int [] arr1 = new int[a1];
        for (int i = 0; i < a1; i++) {
            arr1[i] = sc.nextInt();
        }
        int a2 = sc.nextInt();
        int [] arr2 = new int[a2];
        for (int i = 0; i < a2; i++) {
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int l = 0;
        int r = 0;
        StringBuilder sb = new StringBuilder();
        while (l<a1 && r <a2) {
            if (arr1[l] == arr2[r]) {
                sb.append(arr1[l]).append(" ");
                l++;
                r++;
            } else if (arr1[l] > arr2[r])
                r++;
            else
                l++;
        }

        System.out.println(sb.toString());
    }
}
