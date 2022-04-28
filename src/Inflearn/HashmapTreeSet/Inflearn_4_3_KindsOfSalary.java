package Inflearn.HashmapTreeSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inflearn_4_3_KindsOfSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nOfDays = sc.nextInt();
        int chain = sc.nextInt();
        int[] arr = new int[nOfDays];
        for (int i = 0; i < nOfDays; i++) {
            arr[i] = sc.nextInt();
        }

        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < chain; i++) {
            maps.put(arr[i],maps.getOrDefault(arr[i],0)+1);
        }


        int s = chain;
        int r = s;
        StringBuilder sb = new StringBuilder();
        sb.append(maps.size()).append(" ");
        for (int i = s; i < nOfDays; i++) {

            Integer integer = maps.get(arr[i - s]);
            if (integer != 1) {
                maps.put(arr[i-s],integer-1);
            }else
                maps.remove(arr[i-s]);
            maps.put(arr[i],maps.getOrDefault(arr[i],0)+1);
            sb.append(maps.size()).append(" ");
        }
        System.out.println(sb.toString());

    }
}
