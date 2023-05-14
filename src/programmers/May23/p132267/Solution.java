package programmers.May23.p132267;

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        // 바뀐 병 -> (n/a)*b
        // 턴이 지나고 남은 거 n%a + (n/a)*b
        // 끝나는 조건.. n < a일때
        while(n >= a){
            int back = (n/a) * b;
            int elez = n%a;
            answer += back;
            n = back + elez;
        }
        return answer;
    }
}