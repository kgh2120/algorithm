package beak.prev.math2;

import java.util.Arrays;
import java.util.Scanner;
/*
    문제 : 골드바흐의 추축
    난이도 : 실버 1
    특징 : 확실히 소수 문제에서는 에라토스테네스의 체를 활용하니 웬만한 문제는 전부 해결되는 것 같음.
          이 문제에서 가장 키였던 것으로 생각하는 것은, 합을 구할 때 절반으로 잘라서 거기서 부터 소수를
          구했다는 점. 소수 관련 문제에서 기본적으로 생각할 것은 절반으로 쪼개기, 혹은 루트 씌우기 같음.
 */
public class p9020 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();

        for (int i = 0; i < loop; i++) {
            goldVah(sc.nextInt());
        }
    }

    private static void goldVah(int target) {

        int endDNum = target;
        int half = target/2;


        boolean[] isPNum = new boolean[endDNum+1];
        Arrays.fill(isPNum,true);
        isPNum[0] = false;
        isPNum[1] = false;


        for(int i = 2; i*i<=endDNum; i++)
            if(isPNum[i])
                for(int j = i*i; j<=endDNum;j+=i)
                    isPNum[j] = false;

        for(int i = half; i>=2;i--)
            if(isPNum[i])
                if(isPNum[endDNum-i]){
                    System.out.println(i + " " + (endDNum-i));
                    return;
                }
    }
}
