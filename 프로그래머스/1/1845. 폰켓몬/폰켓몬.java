import java.util.Set;
import java.util.HashSet;

class Solution {
    // N 마리가 주어지고 최대 N/2 마리를 선택할 때,
    // 나올 수 있는 종류의 최대값.
    // 종류로 나누고, 종류 vs N/2 중 더 작은 값을 고르면 될 듯.
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);
        int answer = Math.min(set.size(), nums.length / 2);
        return answer;
    }
}