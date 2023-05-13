package programmers.May23.p136798;

import java.util.Arrays;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] numbers = new int[number+1];
        Arrays.fill(numbers,1);
        for(int i = 2; i<=number; i++)
            for(int j = 1; j * i <= number; j++)
                numbers[i*j]++;


        for(int i = 1; i<=number; i++)
            answer += numbers[i] <= limit ? numbers[i] : power;

        return answer;
    }
}