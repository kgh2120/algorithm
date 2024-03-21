import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int COST = 10_0000_0000;

    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];

        for (int[] row : matrix) {
            Arrays.fill(row,COST);
        }

        for (int i = 0; i < n; i++) {
            matrix[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) -1;
            int b = Integer.parseInt(st.nextToken()) -1;


            int cost = Integer.parseInt(st.nextToken());
            matrix[a][b] = Math.min(matrix[a][b], cost);
        }

        for (int k = 0; k < n; k++) {
            for(int i = 0; i< n; i++){
                for(int j = 0; j< n; j++){
                    if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for(int j = 0; j<n ; j++){
                if(matrix[i][j] >= COST)
                    matrix[i][j] = 0;
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }



}