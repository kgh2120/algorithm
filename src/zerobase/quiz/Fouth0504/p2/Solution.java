package zerobase.quiz.Fouth0504.p2;

class Solution {
    /*
    시작과 끝
    *~~~  endWith
    ~~~* startWith
    */
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for(int i = 0; i<queries.length; i++){
            String query = queries[i];
            // startWith인지, endWith인지 체크
            int count = 0;
            for(String word : words){
                if(query.charAt(0)=='*'){
                    if(word.endsWith(query.substring(1,query.length())))
                        count++;
                }else{
                    if(word.startsWith(query.substring(0,query.length()-1)))
                        count++;
                }
            }
            answer[i] = count;
        }


        return answer;
    }
}