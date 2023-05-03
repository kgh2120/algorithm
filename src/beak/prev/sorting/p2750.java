package beak.prev.sorting;

import java.util.Scanner;

/*
    문제 : 수 정렬하기
    난이도 : 브론즈 1
    특징 : O(n2)인 정렬 사용하기 였음. 선택정렬과 버블정렬중에서 선택정렬을 썻다.
 */

public class p2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        int[] arr = new int[loop];
        for (int i = 0; i < loop; i++)
            arr[i] = sc.nextInt();

        for(int i = 0; i<arr.length-1;i++){
            for(int j = i; j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

        }
        for (int i = 0; i < loop; i++)
            System.out.println(arr[i]);

    }
}
