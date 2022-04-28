package Inflearn.HashmapTreeSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inflearn_4_4_AllAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        int base = a.length();
        int chain = b.length();
        int result = 0;
        Map<Character, Integer> maps = new HashMap<>();

        for (int i = 0; i < chain - 1; i++) {
            maps.put(a.charAt(i),maps.getOrDefault(a.charAt(i),0)+1);
        }
        char[] as = a.toCharArray();
        int s = chain - 1;
        for (int i = s; i < base; i++) {
            maps.put(as[i],maps.getOrDefault(as[i],0)+1);
            if(isSame(maps,b))
                result++;

            Integer integer = maps.get(as[i - s]);
            if (integer != 1) {
                maps.put(as[i-s],integer-1);
            }else
                maps.remove(as[i-s]);
        }

        System.out.println(result);
    }

    private static boolean isSame(Map<Character,Integer> map, String con) {

        HashMap<Character, Integer> nMap = new HashMap<>(map);

        char[] chars = con.toCharArray();
        for (char aChar : chars) {
            if (!nMap.containsKey(aChar) || nMap.get(aChar) == 0) {
                return false;
            }else
                nMap.put(aChar,nMap.get(aChar)-1);
        }
        return true;
    }
}
