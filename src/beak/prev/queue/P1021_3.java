package beak.prev.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class P1021_3 {


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int[] targetArray = new int[k];
        st = new StringTokenizer(br.readLine());
        int idx = 0;
        while(st.hasMoreTokens())
            targetArray[idx++] = Integer.parseInt(st.nextToken());

        dequeue(list,targetArray);


    }

    private void dequeue(List<Integer> list , int[] array){
        int currentIdx = 0;
        int totalRotateCount = 0;
        for (int i : array) {
            Integer value = i;
            int targetIdx = list.indexOf(value);

            totalRotateCount += rotate(list,currentIdx,targetIdx);
            currentIdx = targetIdx;
            list.remove(value);
            if(currentIdx == list.size())
                currentIdx = 0;
        }
        System.out.println(totalRotateCount);
    }

    private int rotate(List<Integer> list , int curIdx, int targetIdx){

        int left = list.size() - targetIdx + curIdx;
        if(curIdx > targetIdx)
            left = targetIdx+ (list.size() - curIdx);

        return Math.min(Math.abs(targetIdx - curIdx), left);
    }




    public static void main(String[] args) throws Exception {
        new P1021_3().solution();
    }

}
