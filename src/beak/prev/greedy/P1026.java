package beak.prev.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    그리디 알고리즘 실버 4
    프로그래머스가 너무 어려워서 하남자같이 백준 쉬운문제로 도망쳤다.
    두 배열의 곱의 합을 구하는 문제였음.
    각 과정에서 가장 낮은 값을 구하는 식으로 원하는 듯 함.
    배열 한쪽은 내림차순, 반대는 오름차순으로 정렬을 하고, 서로 곱하려 했으나,
    int 배열로 만들어서 for문에서 인덱스를 교차해서 곱해주었음.
 */
public class P1026 {
     public static void main(String []args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int []a = new int[n];
        int []b = new int[n];

        setArray(st,a);
        setArray(new StringTokenizer(br.readLine()),b);

        Arrays.sort(a);
        Arrays.sort(b);

        int total = 0;
        for(int i = 0; i<n; i++){
            total += a[i] * b[n-i-1];
        }

        System.out.println(total);
    }

    private static void setArray(StringTokenizer st, int[] arr){
        int idx = 0;
        while(st.hasMoreTokens())
            arr[idx++] = Integer.parseInt(st.nextToken());

    }
}
