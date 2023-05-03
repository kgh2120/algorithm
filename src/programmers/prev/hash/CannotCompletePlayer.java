package programmers.prev.hash;

import java.util.HashMap;
import java.util.Map;

public class CannotCompletePlayer {

    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();
        for (String s : participant) {
            map.put(s, map.getOrDefault(s,0)+1);
        }

        for (String s : completion) {
            Integer i = map.get(s);
            if(i == 1)
                map.remove(s);
            else
                map.put(s,i-1);
        }

        return map.keySet().stream().findFirst().get();

    }

    public static void main(String[] args) {

        String[] a = {"mislav", "stanko", "mislav", "ana"};
        String[] b = {"stanko", "ana", "mislav"};

        System.out.println(new CannotCompletePlayer().solution(a,b));
    }
}