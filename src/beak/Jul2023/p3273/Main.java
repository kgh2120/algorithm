package beak.Jul2023.p3273;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


/**
 * @url : https://www.acmicpc.net/problem/3273
 * @info : BOJ S3
 * @time : 10min
 * @try : 2
 * @type : Hashing
 * @perfomance : memory : 33728KB, time : 320ms
 */
public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        Map<Integer,Boolean> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map.put(Integer.parseInt(st.nextToken()), true);
        }
        int target =  Integer.parseInt(br.readLine());

        int result = 0;
        for(Integer key : map.keySet()){
            if(map.containsKey( target - key)){
                result++;
            }
        }

        System.out.println(result/2);


    }




}