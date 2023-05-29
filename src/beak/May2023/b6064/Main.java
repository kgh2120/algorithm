package beak.May2023.b6064;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k<n; k++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 같은 거 구하기 x 집합과 y집합 중에서
            int limit = M * N;
            int i = 0;
            int j = 0;
            int answer = 0;
            int tempX = x;
            int tempY = y;
            while(true){
                tempX = x + M * i;
                tempY = y + N * j;
                if(tempX > limit || tempY > limit){
                    sb.append(-1).append("\n");
                    break;
                }
                if(tempX==tempY){
                    sb.append(tempX).append("\n");
                    break;
                }
                if(tempX < tempY)
                    i++;
                else
                    j++;

            }
        }
        System.out.println(sb.toString());

    }
}