package Inflearn.twoPointerslidewindow;

import java.util.Scanner;

public class inflearn3_5_continousSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nOfNum = sc.nextInt();
        int target = nOfNum;

        int[] num = new int[nOfNum+1];
        for (int i = 0; i < nOfNum; i++) {
            num[i] = i+1;
        }

        // 초기값 설정
        int l= 0, r = 0;
        int sum = num[l];
        int  result = 0;
        while (l <= r && r < nOfNum) {
            if (l == r && num[l] > target) {
                l++;
                r++;
                sum = num[l];
            }
            else if (sum < target) {
                sum += num[++r];
            } else if (sum == target && l!=r) {
                sum = sum - num[l++] + num[++r];
                result++;
            }else
                sum = sum - num[l++];

        }

        System.out.println(result);


    }
}
