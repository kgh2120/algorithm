package beak.collectionMap;
/* Java(자바) Hello, World! 예제 */

import java.util.*;
import java.io.*;

public class p14425 {
    public static void main(String []args) throws Exception {
        new p14425().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nOfSet = Integer.parseInt(st.nextToken());
        int nOfLine = Integer.parseInt(st.nextToken());
        Set<String> cards = new HashSet<>();

        for(int i = 0; i<nOfSet; i++)
            cards.add(br.readLine());
        int result = 0;
        for(int i =0; i<nOfLine; i++){
            if(cards.contains(br.readLine()))
                result++;
        }

        System.out.println(result);

    }
}