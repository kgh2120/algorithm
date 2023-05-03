package programmers.prev.dfsbfs;

import java.io.IOException;

public class TargetNumber {



    int answer = 0;
    public int solution(int[] numbers, int target) {
        b(numbers,0,target,0,0);
        return answer;
    }

    public void b(int[]numbers, int prev, int target, int depth, int w){
        if(depth == numbers.length){
            if(target == w)
                answer++;
            return;
        }

        if(prev == numbers.length)
            return;

        b(numbers,prev+1,target,depth+1,w + numbers[prev]);
        b(numbers,prev+1,target,depth+1,w - numbers[prev]);

    }



    public static void main(String[] args) throws IOException {


//        System.out.println(((new Solution().solution())));



    }
}