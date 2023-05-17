package programmers.May23.w3.p70129;

class Solution {
    /*
    0. s가 "1"인지 체크한다.
    1. s의 0의 개수를 센다.
    2. 0을 제거한다. s.replace("0","");
    3. s의 length를 toBinary로 한다.
    4. 반복
    */
    public int[] solution(String s) {
        int nOfZero = 0;
        int nOfLoop = 0;
        while(!s.equals("1")){
            nOfLoop++;
            nOfZero += getNumberOfZero(s);
            s = removeZero(s);
            s = convertBinary(s);
        }
        int[] answer = {nOfLoop,nOfZero};
        return answer;
    }

    private String convertBinary(String s) {
        return Integer.toBinaryString(s.length());
    }

    private String removeZero(String s) {
        s = s.replace("0","");
        return s;
    }

    private int getNumberOfZero(String s){
        int nOfZero = 0;
        for(char c : s.toCharArray())
            if(c == '0')
                nOfZero++;
        return nOfZero;
    }
}