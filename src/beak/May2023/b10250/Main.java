package beak.May2023.b10250;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int k = N / H +1;
            int j = N % H;
            sb.append(j ==0 ? H : N%H);
            if(j == 0 )
                k--;
            if(k >= 10){
                sb.append(k);
            }else
                sb.append(0).append(k);
            sb.append("\n");
        }

        System.out.println(sb);
    }

}