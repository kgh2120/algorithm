package zerobase.quiz.oneone;

public class P1 {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i<=n; i++)
            answer += i;
        return answer;
    }

}
