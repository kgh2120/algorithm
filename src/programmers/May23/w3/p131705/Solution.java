package programmers.May23.w3.p131705;

class Solution {
    int answer ;
    public int solution(int[] number) {
        answer = 0;
        // 3명을 더해서 0이 되는 케이스를 찾아라
        // 한명을 고르고, 나머지 두명이 그 애의 음수가 되는 애를 찾아라
        // 조합
        combination(0,0,0,number);

        return answer;
    }
    private void combination(int depth, int idx, int weight, int[] number){
        if(depth == 3){
            if(weight == 0)
                answer++;
            return;
        }

        for(int i = idx; i<number.length; i++)
            combination(depth+1, i+1, weight+number[i], number);
        return;
    }
}