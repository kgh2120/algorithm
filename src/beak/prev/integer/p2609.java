package beak.prev.integer;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * 최대공약수 최대공배수 구하기 문제
 * 유클리드 호제법 알고리즘이 나왔음
 */
public class p2609 {
    public static void main_by_me(String[] args) throws IOException {
        Scanner sc = new Scanner(in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int min = Math.min(n1, n2);
        int m = 1;
        for (int i = min; i >=1 ; i--) {
            if (n1 % i == 0 && n2 % i == 0) {
                m = i;
                break;
            }
        }

        int a = n1/m;
        int b = n2 / m;
        System.out.println(m);

        System.out.println(m * a*b);
    }

        public static void main (String[]args){
            Scanner sc = new Scanner(in);
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            int max = Math.max(n1, n2);
            int min = Math.min(n1, n2);
            int gcd = gcd(max, min);
            System.out.println(gcd);
            System.out.println((n1 / gcd) * (n2 / gcd) * gcd);

        }

        // 유클리드 호제법
        public static int gcd ( int a, int b){
            if (b == 0) {
                return a;
            } else {
                return gcd(b, a % b);
            }


        }

    }