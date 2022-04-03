package beak.brootForce;

import java.util.Scanner;

/*
    문제 : 영화감독 숌
    난이도 : 실버 5
    특징 : 이따위로 풀어도 된다고? 할 정도의 문제..
           꼭 복잡하게 풀어야 하는 것은 아닌 것 같다...
 */
public class p1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int seqence = sc.nextInt();
        int count = 0;
        for(int i = 666; i<Integer.MAX_VALUE;i++){
            if(Integer.toString(i).contains("666"))
                count++;
            if(count==seqence){
                System.out.println(i);
                break;
            }
        }

    }
}
