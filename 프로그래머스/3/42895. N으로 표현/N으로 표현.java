import java.util.*;

class Solution {
    int[] dp;
    Queue<Integer> q;
    List<Integer> numbers;
    public int solution(int N, int number) {
        int answer = 0;
        dp = new int[number * 100 + 1];
        Arrays.fill(dp, 9);
        numbers = new ArrayList<>();
        q = new ArrayDeque<>();
        int k = N;
        int i = 1;
        while(k < dp.length){
            dp[k] = i;
            numbers.add(k);
            q.add(k);
            k = k*10 + N;
            i++;

        }

        while(!q.isEmpty()){
            int num = q.poll();
            // numbers에 있는 애들 + - * / 하기
            int size = numbers.size();

            for(int idx = 0; idx<size; idx++){
                int op = numbers.get(idx);
                int turn = dp[num] + dp[op];
                if(turn > 8) continue;
                add(num + op, turn);
                add(num - op, turn);
                add(op - num, turn);
                add(num * op, turn);
                add(num / op, turn);
                add(op / num, turn);

            }

        }

        answer = dp[number];
        if(answer > 8)
            answer = -1;



        return answer;
    }

    private void add(int next, int prevCount){
        if(next <=0 || next >= dp.length) return;
        if(dp[next] > prevCount){
            dp[next] = prevCount;
            if(dp[next] < 8){
                if(!numbers.contains(next))
                    numbers.add(next);
                q.add(next);
            }
        }


    }

}