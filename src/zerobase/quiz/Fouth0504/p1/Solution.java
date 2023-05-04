package zerobase.quiz.Fouth0504.p1;

class Solution {
    /*
    가사만 안다.
    타이틀 - 가사
    문제는 M개
    시작 가사가 일치하는 모든 노래 제목
    */
    public String[][] solution(String[] titles, String[] lyrics, String[] problems) {
        int M = problems.length;
        int N = lyrics.length;
        String[][] answer = new String[M][N];
        for(int i = 0; i< M ;i++ ){
            String p = problems[i];
            // 포함된 애들 찾아서 넣기
            int k = 0;
            String[] temp = new String[N];
            for(int j = 0; j<N; j++){
                if(lyrics[j].startsWith(p)){
                    temp[k++] = titles[j];
                }
            }

            answer[i] = new String[k];
            for(int a = 0; a < k; a++){
                answer[i][a] = temp[a];
            }
        }
        return answer;
    }
}