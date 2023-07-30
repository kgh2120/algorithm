package beak.Jul2023.p16926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n,m,r;
    static int[][] matrix;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        matrix = new int[n][m];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++)
                matrix[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<r; i++)
            rotate(0,0,n-1,m-1);

        for (int[] m : matrix) {
            for (int num : m) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void rotate(int startRow, int startCol, int endRow, int endCol){

        if(startRow>endRow || startCol > endCol){
            return;
        }


        int leftTop = matrix[startRow][startCol];
        int leftBottom = matrix[endRow][startCol];
        int rightTop = matrix[startRow][endCol];
        int rightBottom = matrix[endRow][endCol];

        for(int i = endRow; i> startRow; i--)
            matrix[i][startCol] = matrix[i-1][startCol];

        for(int i = endCol; i> startCol; i--)
            matrix[endRow][i] = matrix[endRow][i-1];
        matrix[endRow][startCol+1] = leftBottom;

        for(int i = startRow; i<endRow; i++)
            matrix[i][endCol] = matrix[i+1][endCol];
        matrix[endRow-1][endCol] = rightBottom;

        for(int i = startCol; i<endCol;i++)
            matrix[startRow][i] = matrix[startRow][i+1];
        matrix[startRow][endCol-1] = rightTop;

        rotate(startRow+1,startCol+1,endRow-1,endCol-1);



    }


}