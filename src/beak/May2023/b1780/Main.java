package beak.May2023.b1780;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int m1;
    static int zero;
    static int p1;
    static int [][] matrix;
    static final int NOT_SAME = -100;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        matrix = new int[n][n];
        StringTokenizer st = null;
        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while(st.hasMoreElements())
                matrix[i][j++] = Integer.parseInt(st.nextToken());
        }
        if(n == 1){
            int num = matrix[0][0];
            if(num == -1)
                m1++;
            if(num == 0)
                zero++;
            if(num == 1)
                p1++;



        }else
            calc(0,0,n);



        StringBuilder sb = new StringBuilder();
        sb.append(m1).append("\n")
                .append(zero).append("\n")
                .append(p1).append("\n");
        System.out.println(sb);

    }
    private static int calc(int sr, int sc, int n){
        // 마지막 칸일 때
        boolean isSame = true;
        int prev = matrix[sr][sc]; // isSame 공식이 이상하다. 전체가 다 같아야 하는데;
        if(n == 3){
            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                    int num = matrix[sr+i][sc+j];
                    if(num == -1)
                        m1++;
                    if(num == 0)
                        zero++;
                    if(num == 1)
                        p1++;
                    isSame = isSame && (num == prev);
                    prev = num;
                }
            }
        }else{
            // 분할하기 9개로
            int next = n/3;


            for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                    int num = calc(sr + (next * i),sc + (next * j),next);
                    if(!(i == 0 && j == 0))
                        isSame = isSame && (num == prev);
                    prev = num;
                }
            }
        }
        if(isSame){
            if(prev == -1)
                m1 -= 8;
            if(prev == 0)
                zero -= 8;
            if(prev == 1)
                p1 -= 8;
            return prev;
        }
        return NOT_SAME;
    }
}