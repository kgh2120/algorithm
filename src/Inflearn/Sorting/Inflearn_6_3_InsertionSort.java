package Inflearn.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Inflearn_6_3_InsertionSort {

    public static void summit(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nOfNum = sc.nextInt();
        int[] arr = new int[nOfNum];
        Arrays.fill(arr, -1);
        for (int i = 0; i < nOfNum; i++) {
            int target = sc.nextInt();
            insertionSort(arr, target, i);
        }
        StringBuffer sb = new StringBuffer();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void insertionSort(int[] arr, int target, int index) {

        for (int i = 0; i <= index; i++) {
            if (arr[i] == -1) {
                arr[i] = target;
            } else {
                if (arr[i] > target) {
                    System.arraycopy(arr, i, arr, i + 1, arr.length - i - 1);
                    arr[i] = target;
                    break;
                }
            }
        }
    }

    public static void solution(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nOfNum = sc.nextInt();
        int[] arr = new int[nOfNum];
        Arrays.fill(arr, -1);
        for (int i = 0; i < nOfNum; i++) {
            int target = sc.nextInt();
            arr[i] = target;
            insertionSort(arr, i);
        }

        StringBuffer sb = new StringBuffer();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());

    }


    private static void insertionSort(int[] arr, int index) {
        int temp = arr[index];
        int k = 0;
        for (int i = index - 1; i >= 0; i--) {
            if (arr[i] > temp) {
                arr[i + 1] = arr[i];
            } else {
                k = i + 1;
                break;
            }
        }
        arr[k] = temp;
    }
}