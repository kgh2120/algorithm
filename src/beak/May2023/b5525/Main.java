package beak.May2023.b5525;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *  ref : https://velog.io/@lifeisbeautiful/Java-%EB%B0%B1%EC%A4%80-5525%EB%B2%88-IOIOI-with-%EC%9E%90%EB%B0%94
 */
class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int count = 0;
        //count == n 이 되면 Pn이 있는 것
        char [] c= br.readLine().toCharArray();
        int answer = 0;
        for(int i = 1 ; i < m-1; i++){
            // IOI인지 체크하기
            if(c[i-1] == 'I' && c[i] == 'O' && c[i+1] == 'I'){
                count ++ ;
                if(count == n){
                    answer ++;
                    count --;
                }
                i ++;
            }else
                count = 0;
        }


        System.out.println(answer);
    }





}