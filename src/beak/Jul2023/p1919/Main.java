package beak.Jul2023.p1919;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @url : https://www.acmicpc.net/problem/1919
 * @info : BOJ B2
 * @time : 8min
 * @try : 1
 * @type : 문자열, 카운팅
 * @performance : memory : 11580, time : 84ms
 */
public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {

        Map<Character, Integer> leftMap = new HashMap<>();
        Map<Character, Integer> rightMap = new HashMap<>();

        String left = br.readLine();
        for(char c : left.toCharArray())
            leftMap.put(c, leftMap.getOrDefault(c,0)+1);
        String right = br.readLine();
        for(char c : right.toCharArray())
            rightMap.put(c, rightMap.getOrDefault(c,0)+1);

        char index = 'a';

        int dupCount = 0;
        while(index <= 'z'){
            dupCount += Math.min(leftMap.getOrDefault(index,0), rightMap.getOrDefault(index,0));
            index++;
        }

        System.out.println(left.length() + right.length() - dupCount * 2);




    }





}