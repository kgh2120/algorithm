package programmers.May23.w3.p12939;

import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);

        int[] numbers = new int[st.countTokens()];
        for(int i = 0; i<numbers.length;i++)
            numbers[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(numbers);
        return numbers[0] + " " + numbers[numbers.length-1];

    }
}