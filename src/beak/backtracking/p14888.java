package beak.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


/*
    연산자 끼워넣기 문제 - 삼성 뭐시기 기출이란다.
    N퀸하고 스도쿠때 했던 방식처럼 recursive와 for-loop을 돌릴 대상을 설정하고
    작성하니 쉽게 풀렸음.
    다만 Map.get(i)가 값이 변하는데 그걸 다시 써서 처음 테스팅때 값이 틀리게 나왔었음

 */

public class p14888 {


    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, Integer> operatorMap = new HashMap<>();
        StringTokenizer s = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operatorMap.put(i,Integer.parseInt(s.nextToken()));
        }
        operate(arr,operatorMap,0,0,0);

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(min);
        System.out.println(sb);


    }

    public static void operate(int[]arr,Map<Integer,Integer> op, int level, int current, int selectedOps) {
        if (arr.length-1 == level) {
            // final 결과 만들기
            int result = ops(level, current, arr[level], selectedOps);
            // 비교하기 Max, Min
            max = Math.max(max,result);
            min = Math.min(min, result);
            return;
        }

        int select = arr[level];
        for (int i = 0; i < 4; i++) {
            if (isValidOps(op, i)) {
                Integer origin = op.get(i);
                op.put(i, origin -1);
                int ops = ops(level, current, select, selectedOps);
                operate(arr,op,level+1,ops,i);
                op.put(i,origin);
            }
        }
    }

    public static int ops(int level, int current,int select, int ops) {
        if(level==0)
            return select;

        switch (ops) {
            case 0: return current+select;
            case 1:return current-select;
            case 2:return current*select;
            case 3:return current/select;
            default: return select;
        }

    }

    public static boolean isValidOps(Map<Integer,Integer> op, int i) {
        return op.get(i)>0;
    }




}