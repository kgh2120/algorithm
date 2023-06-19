package beak.June2023.b10808;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Map<Character,Integer> map = new HashMap<>();

        char c = 'a';
        while(c != 'z'+1){
            map.put(c,0);
            c++;
        }

        for(char word : input.toCharArray()){
            map.put(word, map.get(word)+1);
        }

        StringBuilder sb = new StringBuilder();
        for(Entry<Character,Integer> e : map.entrySet()){
            sb.append(e.getValue()).append(" ");
        }
        System.out.println(sb);
    }
}