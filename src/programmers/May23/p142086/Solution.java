package programmers.May23.p142086;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character,Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        for(int i = 0; i<s.length();i++){
            int index = map.getOrDefault(c[i],-1);
            index = index == -1 ? -1 : i - index;
            answer[i] = index;
            map.put(c[i],i);
        }

        return answer;
    }
}