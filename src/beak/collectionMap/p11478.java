package beak.collectionMap;

/* Java(자바) Hello, World! 예제 */

import java.util.*;
import java.io.*;
import java.lang.String;

public class p11478 {
    String n;
    public static void main(String []args) throws Exception {
        new p11478().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = br.readLine();
        int size = n.length();
        int loop = (size*(size+1))/2;
        Map<String,Integer> map = new HashMap<>();
        int depth = 0;
        while(loop -- > 0){
            for(int i = 0; i<size-depth; i++){
                String sub = n.substring(i,i+depth+1);



                map.put(sub,1);

            }
            depth++;
        }

        System.out.println(map.keySet().size());

    }
}
