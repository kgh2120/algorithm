import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);
        
        answer = Math.min(set.size(), nums.length/2);
        
        return answer;
    }
}