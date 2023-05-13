package programmers.May23.p161989;

class Solution {
    public int solution(int n, int m, int[] sections) {
        int answer = 0;

        int idx = 0;

        while(idx < sections.length){
            answer++;
            int start = sections[idx++];
            while(idx < sections.length){
                if(m+start > sections[idx])
                    idx++;
                else
                    break;
            }
        }

        return answer;
    }
}