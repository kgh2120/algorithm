package programmers.May23.p140108;

class Solution {
    public int solution(String s) {
        int answer = 0;


        char[] chars = s.toCharArray();
        char base = '0';
        int nOfBase = 0;
        int nOfElse = 0;
        for(int i = 0; i< chars.length; i++){
            if(i == chars.length-1){
                answer++;
                break;
            }
            if(base == '0'){
                base = chars[i];
                nOfBase++;
                continue;
            }


            if(base == chars[i])
                nOfBase++;
            else{
                nOfElse++;
                if(nOfBase==nOfElse){
                    nOfBase = 0;
                    nOfElse = 0;
                    answer++;
                    base = '0';
                }
            }
        }
        return answer;
    }
}