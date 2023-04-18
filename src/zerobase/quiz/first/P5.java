package zerobase.quiz.first;

public class P5 {
    int memo[][];
    long answer;
    public long solution(int N, int M, int K, int[] capacity) {
        answer = 0;

        memo = new int[N+1][11];
        for(int i = 1; i<=N; i++){
            memo[i][0] = 1;
        }
        for(int i = 1; i<=Math.min(N,10); i++){
            memo[i][1] = i;
            memo[i][i] = 1;
        }
        findOutcomes(N,M,capacity,0,1);
        answer *= permutation(K,M);
        return answer;
    }

    private void findOutcomes(int N, int M, int [] capacities, int c, long w){
        if(c == M){
            if(N >0)
                return;
            answer+=w;
            return;
        }
        for(int i = capacities[c]; i>=0; i--){
            if(N < i)
                continue;
            long cur = comb(N,i);
            findOutcomes(N-i, M, capacities, c+1, w*cur);
        }
    }

    private long permutation(int n, int r){
        long rt = 1;
        for(int i = 0; i <r; i++)
            rt*= (n-i);
        return rt;
    }

    private int comb(int n, int r){
        if(n <= 0 || r <= 0)
            return 1;
        if(memo[n][r] != 0)
            return memo[n][r];

        return memo[n][r] = comb(n-1,r) + comb(n-1,r-1);
    }

    public static void main(String[] args) {
        System.out.println(new P5().solution(10,3,4,new int[]{3,3,4}));

    }

}
