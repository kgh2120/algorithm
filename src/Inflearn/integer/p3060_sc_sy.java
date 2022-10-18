package Inflearn.integer;

import java.util.Scanner;

public class p3060_sc_sy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nOfRing = sc.nextInt();
        int[] arr = new int[nOfRing];
        for (int i = 0; i < nOfRing; i++) {
            arr[i] = sc.nextInt();
        }

        // 0번으로 1도 돌리고 2도 돌리고~
        for (int i = 1; i < nOfRing; i++) {
            rolling(arr[0],arr[i]);
        }

    }

    public static void rolling(int firstRing, int ring) {
        int gcd = gcd(Math.max(firstRing,ring),Math.min(firstRing,ring));

//        sb.append(firstRing/gcd)
//                .append("/")
//                .append(ring/gcd);
        System.out.println(firstRing/gcd + "/" + ring/gcd);
    }

    public static int gcd(int a, int b) {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }


}