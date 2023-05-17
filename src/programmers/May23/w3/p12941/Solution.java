package programmers.May23.w3.p12941;

import java.util.Arrays;

class Solution
{
    /*
    숫자를 어떻게 뽑아야 최소가 될 까?
    가장 큰 수 * 가장 작은 수를 해야 최소 값이 나올 듯 싶다.
    그럼 두 배열을 모두 정렬을 해주고,
    하나는 앞에서, 하나는 뒤에서부터 뽑자.
    */
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int j = B.length-1;
        for(int i = 0; i<A.length; i++){
            answer += A[i] * B[j-i];
        }

        return answer;
    }
}