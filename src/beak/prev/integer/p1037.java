package beak.prev.integer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

/**
 *  문제 : 약수
 *  주어진 약수들을 통해 원래 수를 구하는 문제
 */
public class p1037 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(in);
        int nOfCond = sc.nextInt();
        int[] arr = new int[nOfCond];
        for (int i = 0; i < nOfCond; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int originNum = 0;
        if (nOfCond % 2 == 1) {
            int mid = nOfCond/2;
            originNum = arr[mid] * arr[mid];
        } else {
            originNum = arr[0] * arr[nOfCond - 1];

        }

        System.out.println(originNum);
    }

}