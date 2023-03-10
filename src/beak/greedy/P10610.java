package beak.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    그리디 알고리즘 실버 4
    30의 배수를 만드는 문제
    3의 배수는 모든 자리를 합해서 3의 배수가 나오면 3의 배수였다 신기하다.

 */
public class P10610 {


    public String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = br.readLine();
        int[] n = new int [value.length()];

        boolean flag = false;
        for(int i = 0; i<value.length();i++){
            int v = value.charAt(i) - 48;
            if(v == 0){
                flag = true;
            }
            n[i] = v;
        }

        if(!flag){
            return "-1";
        }

        int sum = Arrays.stream(n).sum();
        if(sum % 3 != 0)
            return "-1";

        Arrays.sort(n);
        StringBuilder sb = new StringBuilder();
        for(int i = n.length-1 ; i>=0; i--)
            sb.append(n[i]);

        return sb.toString();
    }




    public static void main(String[] args) throws IOException {


        System.out.println(((new P10610().solution())));



    }

}
