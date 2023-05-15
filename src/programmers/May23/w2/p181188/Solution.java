package programmers.May23.w2.p181188;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, new Comparator<int[]>(){
            public int compare(int[]o1, int[] o2){
                if(o1[1]==o2[1])
                    return o1[0] - o2[0];
                return o1[1]-o2[1];
            };
        });
        int end = targets[0][1];
        answer ++;
        for(int target[] : targets){
            if(target[0] >= end){
                end = target[1];
                answer++;
            }
        }


        return answer;
    }
}