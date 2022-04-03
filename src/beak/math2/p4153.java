package beak.math2;

import java.io.*;
import java.util.Arrays;

/*
    문제 : 직각삼각형
    난이도 : 브론즈 3
 */

public class p4153 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        try {
            while (true) {
                String [] conditions = br.readLine().split(" ");
                int[] cons = new int[3];
                for(int i = 0; i<3; i++)
                    cons[i] = Integer.parseInt(conditions[i]);

                if(Arrays.compare(cons, new int[]{0, 0, 0}) == 0)
                    break;

                int indexOfMax = findMax(cons);
                int max = cons[indexOfMax] * cons[indexOfMax];
                int others = 0;
                for(int i = 0; i<cons.length; i++){
                    if(i == indexOfMax)
                        continue;
                    others += cons[i] * cons[i];
                }
                if(max == others)
                    bw.write("right\n");
                else
                    bw.write("wrong\n");
            }
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    private static int findMax(int[] arr){
        int max = arr[0];
        int Index = 0;
        for(int i = 1; i<arr.length;i++){
            if(max < arr[i]){
                max = arr[i];
                Index = i;
            }
        }
        return Index;
    }
}
