package Inflearn.recursiveBFSDFS;

import java.util.Scanner;

public class Inflearn_7_8_smallCow {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int now = sc.nextInt();
            int target = sc.nextInt();
            int result = 0;
            if (now <= target) {
                int dist = target-now;
                int e = dist%5;

                if (e < 3) {
                    result = dist/5 + e;
                }else {
                    result = dist/5 + (5-e) + 1;
                }
            }else{
                result = now - target;
            }
            System.out.println(result);

        }
    }



