package beak.May2023.b2630;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int nOfWhite;
    static int nOfBlue;
    static int[][] matrix;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        StringTokenizer st = null;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                matrix[i][j] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        if(n == 1){
            int num = matrix[0][0];
            if(num == 1)
                nOfBlue++;
            else
                nOfWhite++;
        }else
            calc(0,0,n);
        sb.append(nOfWhite)
                .append("\n")
                .append(nOfBlue);
        System.out.println(sb);
    }

    private static int calc(int sr, int sc, int n){
        boolean isSame = true;
        int prev = -1;
        if(n == 2){
            prev = matrix[sr][sc];
            for(int i = 0; i<2; i++)
                for(int j = 0; j<2; j++){
                    int num = matrix[sr+i][sc+j];
                    isSame = isSame && (prev == num);
                    prev = num;
                    if(num == 1)
                        nOfBlue++;
                    else
                        nOfWhite++;
                }
        }else{
            int next = n/2;
            for(int i = 0; i<2; i++)
                for(int j = 0; j<2; j++){
                    int num = calc(sr + (next * i), sc + (next * j), next );
                    if( !(i == 0 && j == 0))
                        isSame = isSame && (prev == num);
                    prev = num;
                }
        }

        if(isSame){
            if(prev == 1)
                nOfBlue -= 3;
            else if(prev == 0)
                nOfWhite -=3;
            return prev;
        }
        return -100;
    }
}