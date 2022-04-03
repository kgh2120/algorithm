package beak.math2;

import java.io.*;


/*
    문제 : 네번째 점
    난이도 : 브론즈 3

 */
public class p3009 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] xArr = new int[3];
        int[] yArr = new int[3];


        try {
            for(int i = 0; i<3; i++) {
                String[] s = new String[0];
                s = br.readLine().split(" ");
                xArr[i] = Integer.parseInt(s[0]);
                yArr[i] = Integer.parseInt(s[1]);
            }
            String retVal = findPoint(xArr) + " " + findPoint(yArr);
            bw.write(retVal);
            bw.flush();
            bw.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static int findPoint(int [] coordinates){
        // find different coordinate
        int dif = coordinates[0];
        if(dif == coordinates[1])
            return coordinates[2];
        else if(coordinates[1] == coordinates[2])
            return dif;
        else
            return coordinates[1];
    }
}
