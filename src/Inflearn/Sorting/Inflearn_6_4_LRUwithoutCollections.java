package Inflearn.Sorting;

import java.util.Scanner;

public class Inflearn_6_4_LRUwithoutCollections {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sizeLimit = sc.nextInt();
        int nOfTask = sc.nextInt();

        int[] arr = new int[sizeLimit];
        for (int i = 0; i < nOfTask; i++)
            work(arr,sc.nextInt());

        StringBuffer sb = new StringBuffer();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());

    }


    public static void work(int[]arr, int num) {
        if (contain(arr, num)) {
            int index = indexOf(arr, num);
            moveRight(arr,index);
        }else{
            addFirst(arr,num);
        }
    }

    private static boolean contain(int[]arr, int num) {
        for (int i : arr)
            if(i==num)
                return true;
        return false;
    }

    private static int indexOf(int[] arr,int num) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==num)
                return i;
        }
        return -1;
    }

    public static void addFirst(int[]arr, int num) {
        moveRight(arr,arr.length-1,num);
    }

    private static void moveRight(int[]arr,int index) {
        moveRight(arr,index,arr[index]);
    }

    private static void moveRight(int[]arr, int targetIndex,int target) {
        int temp = target;
        for (int i = targetIndex; i >0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }
}
