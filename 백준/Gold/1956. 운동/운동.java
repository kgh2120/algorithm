import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int[] dist;
    static final int INF = 10_0000_0000;

    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[v+1][v+1];

        for (int[] ints : matrix) {
            Arrays.fill(ints, INF);
        }


        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weg = Integer.parseInt(st.nextToken());
            matrix[from][to] = weg;
        }

        for (int k = 1; k <= v ; k++) {
            for (int i = 1; i <= v ; i++) {
                for (int j = 1; j <= v ; j++) {
                    if(matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= v ; i++) {
            min = Math.min(min, matrix[i][i]);
        }
        System.out.println(min == INF ? -1 : min);
    }



}