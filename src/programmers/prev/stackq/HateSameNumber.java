package programmers.prev.stackq;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class HateSameNumber {

    public int[] solution(int []arr) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<>();
        q.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            if(arr[i]!=arr[i-1])
                q.add(arr[i]);
        }
        answer = new int[q.size()];
        int index = 0;
        for (Integer integer : q) {
            answer[index++] = integer;
        }

        return answer;
    }








    public static void main(String[] args) {

        int [] a = {1,1,3,3,0,1,1};

        System.out.println(Arrays.toString(new HateSameNumber().solution(a)));
    }
}