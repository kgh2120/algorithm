package beak.Jul2023.p3273;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @url : https://www.acmicpc.net/problem/3273
 * @info : BOJ S3
 * @time : 10min
 * @try : 3
 * @type : two-pointer
 * @performance : memory : 25752KB, time : 296ms
 */
public class Main_2Pointer {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int target =  Integer.parseInt(br.readLine());
        Arrays.sort(array);

        int result = 0;
        int l = 0;
        int r = n-1;
        while(l<r){
            int value = array[l] + array[r];
            if(value == target){
                result++;
                l++;
                r--;
            }else if(value < target)
                l++;
            else
                r--;
        }

        System.out.println(result);


    }




}