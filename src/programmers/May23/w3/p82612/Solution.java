package programmers.May23.w3.p82612;

class Solution {
    public long solution(int price, int money, int count) {
        long answer = money;
        for(int i = 1; i<= count ; i++)
            answer -= price * i;

        if(answer >=0)
            return 0;

        return answer * -1;
    }
}