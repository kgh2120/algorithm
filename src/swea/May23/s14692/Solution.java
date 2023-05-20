package swea.May23.s14692;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 1; i<=t; i++){
            int n = Integer.parseInt(br.readLine());
            if (n % 2 == 0) {
                System.out.println("#" + i + " Alice");
            }
            else
                System.out.println("#" + i + " Bob");
        }
    }






}