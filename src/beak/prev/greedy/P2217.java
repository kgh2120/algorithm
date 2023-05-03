package beak.prev.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
    그리디 알고리즘 실버 4
    로프를 병렬로 묶어서 최대 무게를 견디게 하는 문제.
    각 로프 사용 개수 중 최대치를 구했음.
    근데 이게 그리디인지는 모르겠다.
 */
public class P2217 {
    static public void main(String []args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] ropes = new int[n];
        for(int i = 0; i<n; i++)
            ropes[i] = Integer.parseInt(br.readLine());


        Arrays.sort(ropes);

        int maxWeight = -1;

        for(int i =0; i<n; i++)
            maxWeight = Math.max(maxWeight, ropes[i] * (n-i));

        System.out.println(maxWeight);

    }
}
