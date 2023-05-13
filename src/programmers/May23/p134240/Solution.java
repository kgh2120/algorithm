package programmers.May23.p134240;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<food.length ;i++){
            int k = food[i]/2;
            sb.append(Integer.toString(i).repeat(k));
        }
        answer = sb.toString() + "0";
        String right = sb.reverse().toString();
        answer = answer + right;
        return answer;
    }
}