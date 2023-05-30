package programmers.May23.p138476;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int t : tangerine)
            map.put(t,map.getOrDefault(t,0)+1);
        List<Integer> list = new ArrayList(map.values());
        Collections.sort(list,Collections.reverseOrder());

        for(int i = 0; i < list.size();i++){
            int c = list.get(i);
            if(k - c <= 0)
                return i+1;
            k -= c;
        }

        return answer;
    }
}