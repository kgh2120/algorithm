package Inflearn.bfsdfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Inflearn_8_5_ChangeCoin {

    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());

        int target = sc.nextInt();
        DFS(arr, target, 0, 0);
        System.out.println(min);

    }
    public static void DFS(Integer[]arr, int target, int sum, int level) {
        if(sum > target) return;
        if(level >= min) return;
        if (sum == target) {
            min = Math.min(min, level);
        }else{
            for (Integer integer : arr) {
                DFS(arr, target, sum + integer, level + 1);
            }
        }


    }

}