package programmers.May23.w3.p131128;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


class Solution {
    StringBuilder sb;
    public String solution(String X, String Y) {
        String answer = "";
        char[] xChars = X.toCharArray();
        char[] yChars = Y.toCharArray();
        Arrays.sort(xChars);
        Arrays.sort(yChars);


        int l = xChars.length-1;
        int r = yChars.length-1;
        sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        while(l >= 0 && r >= 0){
            char x = xChars[l];
            char y = yChars[r];
            if(x == y){
                set.add(x);
                sb.append(x);
                l--;
                r--;
            }else if(x > y)
                l--;
            else
                r--;

        }


        if(set.size() == 1 && set.contains('0'))
            return "0";
        if(sb.length() == 0)
            sb.append(-1);


        return sb.toString();
    }


}