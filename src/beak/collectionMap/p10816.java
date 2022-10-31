package beak.collectionMap;

/* Java(자바) Hello, World! 예제 */

import java.util.*;
import java.io.*;

public class p10816 {
    public static void main(String []args) throws Exception {
        new p10816().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nOfCard = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String,Integer> cards = new HashMap<>();
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            if(cards.containsKey(token))
                cards.put(token,cards.get(token)+1);
            else
                cards.put(token,1);
        }

        int q = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            int num = cards.getOrDefault(token,0);

            sb.append(num).append(" ");
        }
        System.out.println(sb.toString());

    }
}