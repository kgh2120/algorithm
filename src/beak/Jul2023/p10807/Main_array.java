package beak.Jul2023.p10807;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_array {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    // 단순한 카운트 문제
    // Map에 넣고 한번 돌려보고 - 11616 / 76ms <- map array -> 11752 / 80ms
    // array에 넣고 다시 한번 돌려봐서 시간 체크 해봐야겠다.
    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[201];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
            int target = Integer.parseInt(st.nextToken());
            array[target+100]++;
        }
        int target = Integer.parseInt(br.readLine());
        System.out.println(array[target+100]);


    }




}