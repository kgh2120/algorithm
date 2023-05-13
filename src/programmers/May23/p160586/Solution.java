package programmers.May23.p160586;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < keymap.length; i++){
            int idx = 1;
            for(char c : keymap[i].toCharArray()){
                map.put(c, Math.min(idx++, map.getOrDefault(c,Integer.MAX_VALUE)));
            }
        }

        for(int i = 0; i<targets.length;i++){
            int total = 0;
            for(char c : targets[i].toCharArray()){
                if(!map.containsKey(c)){
                    total = -1;
                    break;
                }
                total +=map.get(c);
            }
            answer[i] = total;
        }
        return answer;
    }
}