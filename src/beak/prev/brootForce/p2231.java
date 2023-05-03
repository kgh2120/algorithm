package beak.prev.brootForce;

import java.util.Scanner;

/*
    문제 : 분해합
    난이도 : 브론즈 2
    특징 : 그렇게 어려운 문제는 아니었던 것 같은데, 예상하지 못한 부분에서 틀린 것 들이 많았다.
           앞으로는 식을 짤 때, 세세한 조건까지 잘 따져봐야 할 것 같다.
 */
public class p2231 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long target = sc.nextInt();

        System.out.println(bunhae(target));

    }

    private static long bunhae(long target){
        // 어차피 본 n자리수 + 각 자리수의 합임.
        // 근데 각 자리수의 합의 최대값은 9*n이다.
        // 그럼 순차적으로 보면 target - 9*n을 한 값에서 부터 찾으면 찾을 수 있음.
        // 근데 이건 가장 작은 수를 찾는 건데
        // 근데 어차피 그 범위 내에 다 들어간다.
        // target - 9*n이 아마 가장 작은 값이 될 것이다.
        long n = nOfTarget(target);

        long min = 0;
        if(target > 9*n)
            min = target - (9*n);

        for(long i = min; i<target; i++){
            if(isConstructor(i,target))
                return i;
        }
        return 0;
    }

    private static boolean isConstructor(long num, long target){
        // 각자리 숫자 구하기
        String con = num+"";
        String[] cons = con.split("");
        long result = num;
        for(int i =0; i<cons.length;i++)
            result += Long.parseLong(cons[i]);

        return target == result;
    }


    private static long nOfTarget(long target){
        long result = target;
        long count = 0;

        while(result != 0){
            result = result/10;
            count++;
        }
        return count;
    }
}
