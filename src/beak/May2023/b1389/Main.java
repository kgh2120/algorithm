package beak.May2023.b1389;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[n+1][n+1];
        for(int [] k : matrix)
            Arrays.fill(k, 5000);

        for(int i = 1; i <= n; i++)
            matrix[i][i] = 0;

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            matrix[f][t] = 1;
            matrix[t][f] = 1;
        }

        for(int k = 1; k <=n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    // 만약 i->k + k => j가 i -> j보다 짧다면 값을 변경한다 엿나?
                    if(matrix[i][k] + matrix[k][j] < matrix[i][j]){
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for(int i = 1; i<=n; i++){
            int total = 0;
            for(int k : matrix[i])
                total += k;
            if(total < min){
                min = total;
                minIdx = i;
            }
        }
        System.out.println(minIdx);



    }
}