package beak.prev.collectionMap;

/* Java(자바) Hello, World! 예제 */

import java.util.*;
import java.io.*;

public class p1620 {
    public static void main(String []args) throws Exception {
        new p1620().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nOfSet = Integer.parseInt(st.nextToken());
        int nOfLine = Integer.parseInt(st.nextToken());
        Map<String,Integer> map = new HashMap<>();
        Map<Integer,String> reverseMap = new HashMap();
        for(int i = 1; i<=nOfSet; i++){
            String name = br.readLine();
            map.put(name,i);
            reverseMap.put(i,name);
        }



        StringBuilder sb = new StringBuilder();
        for(int i =0; i<nOfLine; i++){
            String name = br.readLine();
            try{
                // 숫자일 때
                int index = Integer.parseInt(name);
                sb.append(reverseMap.get(index)).append("\n");
            }catch(NumberFormatException e){
                // 이름일 때
                sb.append(map.get(name)).append("\n");
            }

        }

        System.out.println(sb.toString());

    }
}