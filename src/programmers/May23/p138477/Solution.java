package programmers.May23.p138477;

import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        // min heap을 써서 마지막 꺼 peek 하기
        // if peek보다 들어오는 애가 크다?
        // poll and add

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        answer[0] = score[0];
        pq.add(score[0]);
        for(int i = 1; i< score.length; i++){
            int s = score[i];
            if(pq.size()<k){
                pq.add(s);
            }else{
                if(pq.peek() < s){
                    pq.poll();
                    pq.add(s);
                }
            }
            answer[i] = pq.peek();
        }
        return answer;
    }
}