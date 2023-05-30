package programmers.May23.p147354;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        // 1. col 오름차순,
        Arrays.sort(data, new Comparator<int[]>(){
            public int compare(int[]x,int[]y){
                if(x[col-1] == y[col-1])
                    return y[0] - x[0];
                return x[col-1] - y[col-1];
            }
        });



        int[]si = new int[row_end - row_begin +1];
        int idx = 0;
        for(int i = row_begin; i<=row_end; i++){
            int[] arr = data[i-1];
            int s = 0;

            for(int v : arr)
                s+= v % i;
            si[idx++] = s;
        }

        answer = si[0];
        for(int i = 1; i<si.length; i++)
            answer = answer ^ si[i];



        return answer;
    }
}