package Inflearn.Sorting;

import java.util.*;

/**
 * 결정 알고리즘을 사용하는 문제
 * BinarySearch를 사용해서 범위를 좁혀가고, 해당 값이 사용가능한지를
 * 검증하는 과정으로 진행된다.
 * binary-search는 많이들 하는 방법을 알고 있기 때문에,
 * 검증을 하는 과정이 더욱 중요하다고 한다.
 */

public class Inflearn_6_10_HorseKeep {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nOfKeep = sc.nextInt();
        int nOfHorse = sc.nextInt();

        int[] arr = new int[nOfKeep];
        for (int i = 0; i < nOfKeep; i++) {
            arr[i] = sc.nextInt();
        }


        Arrays.sort(arr);

        // binary 작성
        System.out.println(binarySearch(nOfKeep,nOfHorse,arr));
    }

    public static int binarySearch(int n, int h, int[] arr) {

        int lt = 1;
        int rt = arr[n-1];
        int anw = 0;
        while (lt <= rt) {
            int mid = (lt+rt)/2;

            // validate function
            if (valid(arr, mid) >= h) { // mid값에 배치를 할 수 있다면, 더 최적화된 최소거리를 찾자.
                lt = mid+1;
                anw = mid; // 일단 mid엔 배치가능.
            }else
                rt = mid-1; // mid값에 배치할 수 없다면, 배치할 수 h마리를 배치할 수 있는 거리를 찾자.

        }


        return anw;

    }

    public static int valid(int[]arr, int dist) {
        // dist는 말을 배치할 수 있는 최소의 거리
        // 1번말 위치 , point는 마지막에 위치한 마구간 좌표
        int count = 1; // 1번말을 0번에 배치하고 시작, count는 말의 개수
        int point = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - point >= dist) { // point가 정해졌을 때, 그 다음엔 어떤 마구간에 말을 배치할 수 있는가.
                count++;
                point = arr[i];
            }
        }
        return count;
    }
}