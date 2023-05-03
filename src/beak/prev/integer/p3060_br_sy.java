package beak.prev.integer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3060_br_sy {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nOfRing = Integer.parseInt(br.readLine());
        int[] arr = new int[nOfRing];


        String[] nums = br.readLine().split(" ");

        for (int i = 0; i < nOfRing; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }

//        for (int i = 0; i < nOfRing; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//        StringBuilder sb = new StringBuilder();
        // 0번으로 1도 돌리고 2도 돌리고~
        for (int i = 1; i < nOfRing; i++) {
            rolling(arr[0],arr[i]);
        }
//        System.out.println(sb.toString());
    }

    public static void rolling(int firstRing, int ring) {
        int gcd = gcd(Math.max(firstRing,ring),Math.min(firstRing,ring));

//        sb.append(firstRing/gcd)
//                .append("/")
//                .append(ring/gcd)
//                .append("\n");
        System.out.println(firstRing/gcd + "/" + ring/gcd);
    }

    public static int gcd(int a, int b) {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }


}