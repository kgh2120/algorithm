package beak.Jul2023.p14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @url : https://www.acmicpc.net/problem/14888
 * @info : BOJ S1
 * @time : 15min
 * @try : 4
 * @type : 완탐?
 * @performance : memory : 11808KB, time : 84ms
 */
public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] matrix;
    static int max,min,n;
    static int[] ops;
    public static void main(String[] args) throws Exception {
        initVariables();
        bruteForce(1,matrix[0]);
        sb.append(max)
                .append("\n")
                .append(min);
        System.out.println(sb);
    }

    private static void bruteForce(int current, int weight){
        if(current == n){
            max = Math.max(max, weight);
            min = Math.min(min, weight);
            return;
        }
        for(int i = 0; i<4; i++){
            if(ops[i]==0)
                continue;
            ops[i]--;
            bruteForce(current+1, calc(weight,matrix[current],i));
            ops[i]++;
        }

    }
    private static int calc(int weight, int next, int operation){
        switch (operation){
            case 0 :
                return weight + next;
            case  1 :
                return weight - next;
            case 2 :
                return weight * next;
            case 3 :
                return weight / next;

        }
        return -1;
    }

    private static void initVariables() throws IOException {
        n = Integer.parseInt(br.readLine());
        matrix = new int[n];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            matrix[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        ops = new int[4];
        for(int i = 0; i<4; i++){
            ops[i] = Integer.parseInt(st.nextToken());
        }
    }


}