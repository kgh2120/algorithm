package beak.prev.brootForce;

import java.util.Arrays;
import java.util.Scanner;
/*
    문제 : 덩치
    난이도 : 실버 5

 */

public class p7568 {

    public static void main(String[] args) {

        // 3개의 어레이
        // x어레이, y어레이, 등수 어레이.
        Scanner sc = new Scanner(System.in);
        int nOfCase = sc.nextInt();
        int[] w = new int[nOfCase];
        int[] h = new int[nOfCase];
        int[] rank = new int[nOfCase];

        for(int i = 0; i<nOfCase;i++){
            w[i] = sc.nextInt();
            h[i] = sc.nextInt();
        }
        Arrays.fill(rank,1);
        countRank(w,h,rank);

        for (int j : rank) System.out.print(j + " ");
    }

    private static void countRank(int[]x, int[]y, int[]rank){

        for(int i = 0; i<x.length;i++)
            for(int j=0; j<x.length;j++){
                if(isSmall(x[i],y[i],x[j],y[j]))
                    rank[i]++;
            }
    }

    private static boolean isSmall(int w1, int h1, int w2, int h2){
        return w1 < w2 && h1 < h2;
    }
}
