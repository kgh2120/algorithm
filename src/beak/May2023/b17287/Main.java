package beak.May2023.b17287;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // 독립적으로 구분할 수 있는 녀석.
        // 점수만 넣어.

        int max = -1;
        int score = 0;
        for(char c : s.toCharArray()){
            // 열린 괄호일 때는 점수 ++ 닫힌 괄호일 때는 점수 --
            if(c == '(')
                score +=1;
            else if(c == '{')
                score += 2;
            else if(c == '[')
                score+= 3;
            else if(c == ')')
                score -=1;
            else if(c == '}')
                score -=2;
            else if(c == ']')
                score -=3;
            else
                max = Math.max(max,score);

        }
        System.out.println(max);



    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}