package programmers.sort;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNum {



    public String solution(int[] numbers) {
        String answer = "";
        String[] nums = new String[numbers.length];
        int idx = 0;
        for(int num : numbers)
            nums[idx++] = Integer.toString(num);

        Arrays.sort(nums, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                int a = Integer.parseInt(o1+o2);
                int b = Integer.parseInt(o2+o1);
                return Integer.compare(b, a);
            }
        });


        StringBuilder sb = new StringBuilder();
        for(String n : nums){
            sb.append(n);
        }
        if(sb.charAt(0) == '0')
            return "0";


        return sb.toString();
    }



    public static void main(String[] args) throws Exception {
        int [] a = {6, 10, 2};
        int[][]b = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        String s = new BiggestNum().solution(a);
        System.out.println(s);
    }

}
