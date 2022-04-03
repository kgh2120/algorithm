package beak.math2;

/*
    문제 : 소수
    난이도 : 실버 5
 */

import java.io.*;
import java.util.ArrayList;

public class p2581 {
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int min = Integer.parseInt(br.readLine());
            int max = Integer.parseInt(br.readLine());


            for (int i = min; i <= max; i++) {
                findPrimeNumber(i);
            }

            int total = 0;
            if(arr.size() == 0){
                total = -1;
                bw.write(Integer.toString(total));
            }
            else{
                int minPrime = arr.get(0);
                for(int pNum : arr)
                    total += pNum;

                bw.write(Integer.toString(total)+"\n");
                bw.write(Integer.toString(minPrime));
            }
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void findPrimeNumber(int number){
        if(number == 1)
            return;
        for(int i = number-1; i>= Math.sqrt(number); i--)
            if(number%i == 0)
                return;

        arr.add(number);
    }
}
