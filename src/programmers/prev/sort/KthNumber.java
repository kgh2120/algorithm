package programmers.prev.sort;

import java.util.Arrays;

public class KthNumber {



    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int a = 0; a< commands.length;a++){
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            int[] arr = new int[j-i+1];
            System.arraycopy(array,i-1,arr,0,j-i+1);
            Arrays.sort(arr);
            answer[a] = arr[k-1];
        }

        return answer;

    }



    public static void main(String[] args) throws Exception {
        int [] a = {1, 5, 2, 6, 3, 7, 4};
        int[][]b = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        new KthNumber().solution(a,b);
    }

}
