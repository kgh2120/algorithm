package programmers.May23.p133499;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String [] yesICanDo = { "aya", "ye", "woo", "ma"};
        // replace해서 다 사라지면 ok?
        for(int i = 0; i< babbling.length ;i++){
            String b = babbling[i];
            // 연속해서 하는 거 체크 해야 함.

            int prev = -1;
            loop:while(true){
                for(int j = 0; j< 4; j++){
                    if(prev == j)
                        continue;
                    if(b.startsWith(yesICanDo[j])){
                        prev = j;
                        b = b.replaceFirst(yesICanDo[j],"");
                        continue loop;
                    }
                }
                break;
            }

            if(b.equals(""))
                answer++;

        }
        return answer;
    }
}