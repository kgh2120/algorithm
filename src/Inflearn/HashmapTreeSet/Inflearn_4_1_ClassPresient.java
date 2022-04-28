package Inflearn.HashmapTreeSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Inflearn_4_1_ClassPresient {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nOfStudent = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        String vote = sc.next();
        for (int i = 0; i < nOfStudent; i++) {
            String in = vote.charAt(i)+"";
            int v = 0;
            if (map.containsKey(in)) {
                v = map.get(in);
            }
            map.put(in,++v);
        }


        List<String> strings = new ArrayList<>(map.keySet());
        List<Integer> values = new ArrayList<>(map.values());

        int max = 0;
        int maxIdx = 0;
        for (Integer value : values) {
            max = Math.max(value,max);
            maxIdx = values.indexOf(max);
        }
        System.out.println(strings.get(maxIdx));
    }
}
