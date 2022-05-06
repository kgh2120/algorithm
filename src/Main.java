import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nOfNum = sc.nextInt();
        int[] arr = new int[nOfNum];
        for (int i = 0; i < nOfNum; i++) {
            arr[i] = sc.nextInt();
        }
        sorting(arr);

        StringBuffer sb = new StringBuffer();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());

    }


    private static void sorting(int[]arr) {
        int max = arr.length;

        for (int i = 0; i < max - 1; i++) {
            for (int j =0; j < max-(i+1); j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j+1);
                }
            }
        }
    }


    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}