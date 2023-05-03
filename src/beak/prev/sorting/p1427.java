package beak.prev.sorting;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *  문제 : 소트인사이드
 *  예상 난이도 : 브론즈 2??
 *  실제 난이도 : 실버 5
 *  소감 : 간단한 내림차순 정렬문제, 삽입정렬을 사용해서 해결했다. 너무 오랜만에 푸는 문제라서
 *         간단한 문제인데도 시간이 상당히 소요되었다.
 */

public class p1427 {
    public static void main(String[] args) {
        ArrayList<Integer> lists = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        int[] nums = new int[num.length()];
        for(int i = 0; i<num.length();i++){
            nums[i] = Integer.parseInt(num.charAt(i)+"");
        }
        sortUpper(nums);
    }

    public static void sortUpper(int [] sort) {
        String rs = "";
        for(int i =0; i<sort.length-1; i++){
            int max = sort[i];
            int r = i;
            for(int j = i; j<sort.length;j++){
                if(max < sort[j]){
                    max = sort[j];
                    r = j;
                }
            }
            swap(sort,i,r);
            rs += max;
        }
        rs += sort[sort.length-1];
        System.out.println(rs);

    }

    public static void swap(int[] sort, int l, int r) {
        int temp = sort[r];
        sort[r] = sort[l];
        sort[l] = temp;
    }
}
