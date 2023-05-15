package programmers.May23.w2.p135808;

import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        // score 큰 순으로 정렬해서 박스로 묶어서 판매하면 될 듯 ?
        Arrays.sort(score);
        int count = 0;
        for(int i = score.length-1; i>= 0; i--){
            count++;
            if(count == m){
                int s = score[i];
                answer += s * m;
                count = 0;
            }
        }

        return answer;
    }
}