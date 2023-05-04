package zerobase.quiz.Fouth0504.p3;

class Solution {
    /*
    ? 의 개수가 그.. 남은 글자 수랑 같아야 함.
    app?? -> apple
    size 체크 후 스타트 위드 하기
    */
    public String[][] solution(String[] words, String[] queries) {
        String[][] answer = new String[queries.length][0];


        for(int i = 0; i < queries.length; i++){
            String query = queries[i];
            String[]temp = new String[words.length];
            int idx = 0;
            for(String word : words){
                if(query.length() == word.length()){
                    if(word.startsWith(query.substring(0,query.indexOf("?"))))
                        temp[idx++] = word;
                }
            }
            answer[i] = new String[idx];
            for(int j = 0; j <idx; j++)
                answer[i][j] = temp[j];
        }
        return answer;
    }
}