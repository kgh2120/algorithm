import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nOfNum = sc.nextInt();
        int[] arr = new int[nOfNum];
        Arrays.fill(arr,-1);
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




    private static void insertionSort(int[]arr, int index) {
        int temp = arr[index];
        int k = 0;
        for (int i = index-1; i >=0 ; i--) {
            if (arr[i] > temp) {
                arr[i + 1] = arr[i];
            } else {
               k = i+1;
                break;
            }
        }
        arr[k] = temp;
    }


    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}