package beak.prev.binaryserach;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2110 {
    StringBuilder sb = new StringBuilder();


    public void solution() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      int[] homeArray = new int[n];
        for (int i = 0; i < n; i++) {
            homeArray[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(homeArray);

        System.out.println(findMaximumLength(homeArray,c));
    }

    private int findMaximumLength(int[] homeArray, int c) {
        int l = 1;
        int r = homeArray[homeArray.length-1] - homeArray[0];


        int max = Integer.MIN_VALUE;
        while (l <= r) {

            int mid = (r+l) >>> 1;
// 최소 저 mid를 충족시키는 공유기 배치 개수 n이 c보다 적다면, 거리를 줄인다.
            int n = findN(homeArray, mid);
            if (n < c) {
                r = mid - 1;
            } else {
                max = Math.max(mid, max);
                l = mid + 1;
            }
            // 배치 개수 n이 c보다 크거나 같다면, 이를 만족하는 범위 내에서 최대 값을 찾는다.
        }

        return max;
    }

    private int findN(int[]array, int minLength){

        int l = 0;
        int r = 1;
        int n = 1;
        while (l <= r && r < array.length) {
            // 길이 충족
            if (array[r] - array[l] >= minLength) {
                n++;
                l = r;
                r = r+1;
            }else{
                r++;
            }
        }
        return n;
    }


    public static void main(String[] args) throws Exception {
        new P2110().solution();
    }
}





