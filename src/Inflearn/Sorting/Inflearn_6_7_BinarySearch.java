package Inflearn.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Inflearn_6_7_BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nOfNum = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[nOfNum];
        for (int i = 0; i < nOfNum; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int result = binarySearch(target, arr, 0, nOfNum - 1);
        System.out.println(result+1);

    }

    private static int binarySearch(int target, int []arr, int start, int end) {
        int middle = (start+end)/2;

        if (arr[middle] == target) {
            return middle;
        }

        else if (arr[middle] > target) {
            return binarySearch(target,arr,start,middle-1);

        } else if (arr[middle] < target) {
            return binarySearch(target,arr,middle+1,end);
        }

        return -1;
    }
}
