package beak.May2023.b1259;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            char[] number = br.readLine().toCharArray();
            if(number.length == 1 && number[0] == '0')
                break;
            int l = 0;
            int r = number.length-1;
            boolean flag = true;
            while(l <= r){
                if(number[l] != number[r]){
                    flag = false;
                    break;
                }
                l++;
                r--;
            }
            if(flag){
                sb.append("yes");
            }else
                sb.append("no");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
