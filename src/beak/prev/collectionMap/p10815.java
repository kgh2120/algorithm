package beak.prev.collectionMap;/* Java(자바) Hello, World! 예제 */

import java.util.*;
import java.io.*;

public class p10815 {
	public static void main(String []args) throws Exception {
		new p10815().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nOfCard = Integer.parseInt(br.readLine());
        Set<String> cards = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<nOfCard; i++)
            cards.add(st.nextToken());

        int nOfP = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()){
            if(cards.contains(st.nextToken()))
                sb.append(1).append(" ");
            else 
                sb.append(0).append(" ");
        }
        System.out.println(sb.toString());

    }
}