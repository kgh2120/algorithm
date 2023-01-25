package beak.binaryserach;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920 {
    StringBuilder sb = new StringBuilder();


    public void solution() throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nOfArray = Integer.parseInt(br.readLine());
        long [] array = new long[nOfArray];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nOfArray; i++) {
            array[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(array);

        int nOfTarget = Integer.parseInt(br.readLine());
        long [] targets = new long[nOfTarget];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nOfTarget; i++) {
            targets[i] = Long.parseLong(st.nextToken());
        }
        for (int i = 0; i < nOfTarget; i++) {
            int i1 = Arrays.binarySearch(array, targets[i]);
            if (i1 < 0) {
                sb.append(0).append("\n");
            }else
                sb.append(1).append("\n");
        }

        System.out.println(sb);


    }

    public void binarySearch(int [] array, int target){
        int l = 0;
        int r = array.length-1;
        boolean find = false;
        while (l <= r && !find) {


            int mid = (l+r)/2;

            if (array[mid] > target) {
                r = mid-1;
            }
            if(array[mid] < target)
                l = mid+1;
            if (array[mid] == target) {
                find = true;
            }
        }
        if(find)
            sb.append(1).append("\n");
        else
            sb.append(0).append("\n");


    }






    public static void main(String[] args) throws Exception {
        new P1920().solution();
    }
}





