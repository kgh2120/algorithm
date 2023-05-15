package programmers.May23.w3.p12951;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[]chars = s.toCharArray();
        boolean isFirst = true;
        for(char c : chars){
            if(Character.isDigit(c))
                isFirst = false;
            else if(Character.isWhitespace(c))
                isFirst = true;
            else{
                if(isFirst){
                    c = Character.toUpperCase(c);
                    isFirst = false;
                }
                else c = Character.toLowerCase(c);
            }
            sb.append(c);

        }
        return sb.toString();
    }
}