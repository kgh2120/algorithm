package beak.math2;

import java.util.Arrays;
import java.util.Scanner;

/*
    문제 : 베르트랑 공준
    난이도 : 실버 2
    특징 : 시간이 짧아서, 테스트를 하는데 너무 느린거 같아서 걱정했는데, 한번에 통과했다. 의외다.
          에라토스테네스의 체의 힘인가? 잘 모르겠다.
 */

public class p4948 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int input = sc.nextInt();
            if(input == 0) return;
            isPNum(input);
        }


    }

    private static void isPNum(int startNum) {

        int endDNum = startNum*2;


        boolean[] isPNum = new boolean[endDNum+1];
        Arrays.fill(isPNum,true);
        isPNum[0] = false;
        isPNum[1] = false;


        for(int i = 2; i*i<=endDNum; i++){
            if(isPNum[i]){
                for(int j = i*i; j<=endDNum;j+=i){
                    isPNum[j] = false;
                }
            }
        }
        int count = 0;
        for(int i = startNum+1; i<=endDNum;i++)
            if(isPNum[i])
                count++;

        System.out.println(count);
    }

}
