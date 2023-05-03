package beak.prev.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * n-queen 문제. 추후 복습 필요.
 */
public class n_queen {



    static int r;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int [] q = new int[n];


        n_queen(q,0);
        System.out.println(r);
    }

    public static void n_queen(int []q, int n) {
        if (n == q.length) {
            r++;
            return;
        }

        for (int i = 0; i < q.length; i++) {
            q[n]=i; // n 은 row, i는 col
            if(isValid(q,n))
                n_queen(q,n+1);
        }

    }

    public static boolean isValid(int[]q, int n) {
        for (int i = 0; i < n; i++) {
            if(q[i]==q[n]) return false;
            if(Math.abs(q[i]-q[n])==Math.abs(i-n)) return false;
        }
        return true;
    }








}