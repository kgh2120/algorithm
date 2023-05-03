package beak.prev.math2;

import java.util.Arrays;
import java.util.Scanner;

/*
    문제 : 소수구하기
    난이도 : 실버 2
    특징 : 계속 시간 초과가 나더라.. 기존에 사용하던 primeNumber 구하는 식을 안쓰고
    에라토스테네스의 체 라는 알고리즘을 사용했다.
    N까지의 수 를 0, 1을 제외하고 전부 소수라고 설정을 하고,
    2부터 시작하여 소수인 것에 대해서, 해당 수의 배수들에 대해서 소수가 아니다. 라고 설정을 해줌.
    N의 제곱근의 수 까지 계산을 하고 난 후, 전체 boolean 배열에서 소수(true)인 수들만을
    입력하도록 하였음.
    Scanner와 System.out.println()을 통해서 해서 속도면에서 불리함이 존재했음에도,
    기존의 PrimeNumber 식보다 훨씬 빠르게 통과를 했다.
    참고 : https://ko.wikipedia.org/wiki/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98_%EC%B2%B4
 */

public class p1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startNum = sc.nextInt();
        int endDNum = sc.nextInt();


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

        for(int i = startNum; i<=endDNum;i++)
            if(isPNum[i])
                System.out.println(i);

    }
}
