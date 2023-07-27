package beak.Jul2023.p14503;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] matrix;
    static int r, c, d;
    static int n,m;
    static int[][] deltas = {
            {-1,0}, {0,1}, {1,0}, {0,-1}
    };
    static final int CLEAN = 2;
    static int result;
    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<m; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){

            // 1번 조건
            if(matrix[r][c] == 0){
                matrix[r][c] = CLEAN;
                result++;
                continue;
            }

            // 2번 & 3번 조건

            boolean hasDirty = false;
            for(int[] del : deltas){

                int nextRow = r + del[0];
                int nextCol = c + del[1];
                if(nextRow >=0 && nextRow < n
                    && nextCol >=0 && nextCol < m && matrix[nextRow][nextCol] == 0){
                    hasDirty = true;
                    break;
                }
            }
            if(hasDirty){
                if(d == 0)
                    d = 3;
                else
                    d--;
                int nextRow = r + deltas[d][0];
                int nextCol = c + deltas[d][1];
                if(matrix[nextRow][nextCol] == 0){
                    r = nextRow;
                    c = nextCol;
                }
            }else{
                int nextRow = r + deltas[d][0] * -1;
                int nextCol = c + deltas[d][1] * -1;
                if(matrix[nextRow][nextCol] != 1){ // 뒤로 갈 수 있다면
                    r = nextRow;
                    c = nextCol;
                }else{
                    break;
                }
            }



        }
        System.out.println(result);

    }





}