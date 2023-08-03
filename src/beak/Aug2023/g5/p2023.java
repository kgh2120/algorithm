package beak.Aug2023.g5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
    @author 김규현
    @since 2023-08-03
    @see https://www.acmicpc.net/problem/2023
    @performance
    @category #
    @note

    N자리 소수를 찾는다. 그런데 이 소수가 N-1, N-2, ....1자리 까지 전부 소수를 만족시켜야 한다.
    진짜 이상한 사람인듯..
    소수를 쉽게 찾는 방법으로는 에라토스테네스의 체를 쓰고 싶은데, 4mb밖에 없어서 못쓸듯 싶다.
    그럼 1자리 수부터 소수를 만족하는 애가 쭉쭉 가면서 체크를 하면 될 듯 싶다.
    그런데 그러면 너무 경우가 많으니까 임시로 추려본다면
    1자리 수 소수 : 2,3, 5, 7
    2자리 수 부터 나올 수 없는 끝자리는 0,2,4,5,6,8 은 나올 수 없다.
    그러면 1,3,7,9로만 반복을 돌리면 좀 더 쉬울 듯 싶다.

    그러면 숫자를 계속 축적해주면서, 소수 체크를 해주고,
    n번째 재귀를 들어가고 이를 정답에 넣어준다.

*/
public class p2023 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;

    static int[] init = {2,3,5,7};
    static int[] after = {1,3,7,9};

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());

        for (int i : init) {
            findAmazingPrim(1,i);
        }
        System.out.println(sb);
    }

    private static void findAmazingPrim(int depth, int acc){
        if (depth == n) {
            if (isPrim(acc)) {
                sb.append(acc)
                        .append("\n");
            }
            return;
        }
        int temp = acc * 10;
        for (int i : after) {
            int next = temp+i;
            if(isPrim(next))
                findAmazingPrim(depth+1, next);
        }

    }

    private static boolean isPrim(int number){
        for (int i = 3; i <= Math.sqrt(number); i++) {
            if(number % i == 0)
                return false;
        }
        return true;
    }

}
