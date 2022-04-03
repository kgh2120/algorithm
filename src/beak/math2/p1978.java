package beak.math2;

import java.io.*;


/*
    문제 : 소수찾기 1
    난이도 : 실버 4
 */

public class p1978 {
    static int count = 0;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int loopCount = Integer.parseInt(br.readLine());

            String[] cons = br.readLine().split(" ");
            int[] coons = new int[loopCount];
            for (int i = 0; i < loopCount; i++) {
                coons[i] = Integer.parseInt(cons[i]);
                findPrimeNumber(coons[i]);
            }
            bw.write(Integer.toString(count));
            bw.flush();
            bw.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void findPrimeNumber(int number) {
        if (number == 1)
            return;


        for (int i = number - 1; i >= Math.sqrt(number); i--)
            if (number % i == 0)
                return;

        count++;
    }
}


