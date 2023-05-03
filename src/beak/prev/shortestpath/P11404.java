package beak.prev.shortestpath;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 크루스칼
class P11404 {

    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.MAX_VALUE;

        int nOfCity = Integer.parseInt(br.readLine());
        long [][] matrix = new long[nOfCity+1][nOfCity+1];
        for (long[] longs : matrix) {
            Arrays.fill(longs,max);
        }
        for (int i = 1; i <= nOfCity; i++) {
            matrix[i][i] = 0;
        }

        int nOfBus =  Integer.parseInt(br.readLine());
        for (int i = 0; i < nOfBus; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            matrix[f][t] = Math.min(w, matrix[f][t]);
        }

        for (int k = 1; k <= nOfCity; k++) {
            for (int i = 1; i <= nOfCity; i++) {
                for (int j = 1; j <= nOfCity ; j++) {
                    if (matrix[i][k] != max && matrix[k][j] != max) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= nOfCity ; i++) {
            for (int j = 1; j <= nOfCity ; j++) {
                sb.append(matrix[i][j] == max ? 0 : matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);



    }


    public static void main(String[] args) throws Exception{
        new P11404().solution();
    }
}