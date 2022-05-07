import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nOfNum = sc.nextInt();
        int[] arr = new int[nOfNum];

        for (int i = 0; i < nOfNum; i++) {
            if (insertionSort(arr, sc.nextInt(), i)) {
                System.out.println("D");
                return;
            }
        }
        System.out.println("U");

    }

    public static boolean insertionSort(int[]arr, int num, int index) {
        for (int i = 0; i <= index; i++) {
            if (arr[i] == 0) {
                arr[i] = num;
                break;
            } else if (arr[i] == num) {
                return true;
            } else if (arr[i] > num) {
                for (int j = index-1; j > i; j--)
                    arr[j] = arr[j-1];
                arr[i] = num;
                break;
            }
        }
        return false;
    }



}