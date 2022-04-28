package Inflearn.HashmapTreeSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Inflearn_4_2_Anagram {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            mapA.put(a.charAt(i),mapA.getOrDefault(a.charAt(i),0)+1);
            mapB.put(b.charAt(i),mapB.getOrDefault(b.charAt(i),0)+1);
        }


        if (isSame(mapA.keySet(), mapB.keySet())) {
            Set<Character> keys = mapA.keySet();

            for (Character key : keys) {
                if (mapA.get(key) != mapB.get(key)) {
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
        }else
            System.out.println("NO");



    }

    private static boolean isSame(Set<Character> a, Set<Character>b) {

        return a.containsAll(b) && b.containsAll(a);
    }
}
