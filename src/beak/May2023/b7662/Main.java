package beak.May2023.b7662;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test = 0; test<t; test++){
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer,Integer> map = new TreeMap(); // minTree
            int size = 0;
            StringTokenizer st;
            for(int i = 0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                String ops = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if("I".equals(ops)){
                    size++;
                    map.put(value, map.getOrDefault(value,0)+1);
                }else{
                    if(size == 0)
                        continue;
                    if(value == 1){
                        Entry<Integer,Integer> e = 	map.lastEntry();
                        if(e.getValue() == 1)
                            map.remove(e.getKey());
                        else
                            map.put(e.getKey(),e.getValue()-1);
                    }else{
                        Entry<Integer,Integer> e = 	map.firstEntry();
                        if(e.getValue() == 1)
                            map.remove(e.getKey());
                        else
                            map.put(e.getKey(),e.getValue()-1);
                    }
                    size--;
                }
            }

            if(size != 0){
                sb.append(map.lastKey())
                        .append(" ")
                        .append(map.firstKey());
            }else{
                sb.append("EMPTY");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}