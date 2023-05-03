package beak.May2023.b2480;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {


    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        map.put(a, map.getOrDefault(a,0)+1);
        map.put(b, map.getOrDefault(b,0)+1);
        map.put(c, map.getOrDefault(c,0)+1);

        if (map.size() == 1) {
            System.out.println(10000 + a * 1000);
        }else if (map.size() == 3){
            int max = Math.max(Math.max(a,b),c);
            System.out.println(max * 100);
        }else{
            int target = -1;
            for (Integer integer : map.keySet()) {
                if(map.get(integer) == 2){
                    System.out.println(1000 + integer * 100);
                    return;
                }

            }

        }



    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}