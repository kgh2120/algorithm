package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class PhoneKemon {

    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int half = nums.length/2;

        if(map.size() > half)
            return half;
        return map.size();

    }

    public static void main(String[] args) {

        int [] nums = {3,3,3,2,2,2};

        System.out.println(new PhoneKemon().solution(nums));
    }
}