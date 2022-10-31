package beak.collectionMap;
/* Java(자바) Hello, World! 예제 */

import java.util.*;
import java.io.*;

public class p1764 {
    public static void main(String []args) throws Exception {
        new p1764().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int sound = Integer.parseInt(st.nextToken());
        int see = Integer.parseInt(st.nextToken());
        int min = Math.min(sound,see);
        List<String> answer = new ArrayList<>();


        Set<String> names = new HashSet<>();
        for(int i = 0; i<sound+see; i++){
            String name = br.readLine();
            if(names.contains(name)){
                answer.add(name);
            }else
                names.add(name);
        }
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();

        sb.append(answer.size()).append("\n");
        for(String n : answer)
            sb.append(n).append("\n");

        System.out.println(sb.toString());
    }
}