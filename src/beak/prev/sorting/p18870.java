package beak.prev.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    체감 난이도 : 일단 못품, 시간 제한을 못깻다.
    실제 난이도 : 실버 2
    특징 : 시간 초과에 대해서 잘 생각해야 하는 문제였음. StringBuilder가 일반적인 String보다 효율적이라는 이야기를 알앗다.
    https://st-lab.tistory.com/279
 */
public class p18870 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [] origin = new int[n];
        int [] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            origin[i] = sorted[i] = sc.nextInt();
        }

        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(sorted);

        int rank = 0;
        for (int i : sorted) {
            if (!map.containsKey(i)) {
                map.put(i, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : origin) {
            sb.append(map.get(i)).append(' ');
        }
        System.out.println(sb);


    }
}
