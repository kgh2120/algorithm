package beak.collectionMap;

/* Java(자바) Hello, World! 예제 */

import java.util.*;
import java.io.*;

public class p1269 {
    public static void main(String []args) throws Exception {
        new p1269().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        br.readLine();

        Map<String,Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            if(map.containsKey(token))
                map.put(token,map.get(token)+1);
            else
                map.put(token,1);
        }
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            if(map.containsKey(token))
                map.put(token,map.get(token)+1);
            else
                map.put(token,1);
        }

        Collection<Integer> v = map.values();

        int count = 0;
        for(Integer k : v){
            if(k==1)
                count++;
        }

        System.out.println(count);
    }
}