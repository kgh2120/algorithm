package Inflearn.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Inflearn_6_8_MusicVideo {
    public static void submit(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nOfNum = sc.nextInt();
        int target = sc.nextInt();

        int total = 0;
        int[] arr = new int[nOfNum];
        for (int i = 0; i < nOfNum; i++) {
            int num = sc.nextInt();
            total += num;
            arr[i] = num;
        }
        int avg = total / target;
        int minimumDVD = submitGetMinimumDVD(arr, target, avg);
        System.out.println(minimumDVD);

    }

    private static int submitGetMinimumDVD(int[]arr, int target, int amount) {
        int loop = 0;
        int val = 0;
        for (int i = 0; i < arr.length; i++) {
            val += arr[i];

            if (val == amount) {
                val = 0;
                loop++;
                continue;
            }
            if (i == arr.length - 1) {
                loop++;
                break;
            }
            if (val + arr[i+1] > amount) {
                val = 0;
                loop++;
            }
        }

        if(loop > target)
            return submitGetMinimumDVD(arr,target,amount+1);
        else
            return amount;

    }


    public static void solution(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nOfNum = sc.nextInt();
        int target = sc.nextInt();

        int total = 0;
        int[] arr = new int[nOfNum];
        for (int i = 0; i < nOfNum; i++) {
            int num = sc.nextInt();
            total += num;
            arr[i] = num;
        }

        int minimumDVD = binary(arr, target);
        System.out.println(minimumDVD);

    }

    private static int binary(int[]arr,int target) {
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        int best = 0;
        while (lt <= rt) {
            int mid = (lt+rt)/2;

            int loop = getMinimumDVD(arr, mid);
            if(loop> target)
                lt = mid+1;
            else {
                best = mid;
                rt = mid-1;
            }
        }
        return best;

    }

    private static int getMinimumDVD(int[]arr, int amount) {
        int loop = 0;
        int val = 0;
        for (int i = 0; i < arr.length; i++) {
            val += arr[i];

            if (val == amount) {
                val = 0;
                loop++;
                continue;
            }
            if (i == arr.length - 1) {
                loop++;
                break;
            }
            if (val + arr[i+1] > amount) {
                val = 0;
                loop++;
            }
        }
        return loop;
    }
}
