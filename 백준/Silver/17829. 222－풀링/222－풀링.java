import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] matrix;


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dnq(0,0,n));


    }

    private static int dnq(int sr, int sc, int size) {
        if (size == 2) {
            return findSecondNum(matrix[sr][sc], matrix[sr + 1][sc], matrix[sr][sc + 1],
                    matrix[sr + 1][sc + 1]);
        } else {
            int half = size / 2;
            return findSecondNum(new int[]{
                    dnq(sr, sc, half),
                    dnq(sr + half, sc, half),
                    dnq(sr, sc + half, half),
                    dnq(sr + half, sc + half, half)
            });
        }
    }

    private static int findSecondNum(int... nums) {
        Arrays.sort(nums);
        return nums[2];
    }

}