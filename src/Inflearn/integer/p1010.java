package Inflearn.integer;

import java.io.*;

/**
 * matrix를 한번만 만들어 두고 필요한 좌표값을 꺼내다 쓰는 방식으로 해결
 */
public class p1010 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] caseMatrix = new int[n][2];
        int max = 0;
        for (int i = 0; i < n; i++) {
            String[] nums = br.readLine().split(" ");
            caseMatrix[i][0] = Integer.parseInt(nums[0]);
            int west = Integer.parseInt(nums[1]);
            caseMatrix[i][1] = west;
            max = Math.max(max, west);
        }

        long[][] matrix = new long[max+1][max+1];
        fillMatrix(matrix);

        for (int i = 0; i < n; i++) {
            bw.write(matrix[caseMatrix[i][1]][caseMatrix[i][0]] + "\n");
        }
        bw.flush();

    }

    public static void fillMatrix(long [][]matrix) {


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                if(j==0 || j == i)
                    matrix[i][j] = 1;
                else
                    matrix[i][j] = matrix[i-1][j-1] + matrix[i-1][j];
            }
        }

    }


}