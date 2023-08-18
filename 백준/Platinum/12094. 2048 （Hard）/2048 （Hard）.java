import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[][] mm;
    static int n;
    static int max = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        mm = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int col = 0;
            while (st.hasMoreElements()) {
                mm[i][col++] = Integer.parseInt(st.nextToken());
            }
        }

        find(mm, 0);
        System.out.println(max);

//        for (int[] ints : mm) {
//            System.out.println(Arrays.toString(ints));
//        }


    }

    private static int biggest(int[][] matrix) {
        int m = -1;
        for (int[] row : matrix) {
            for (int col : row) {
                m = Math.max(m, col);
            }
        }
        return m;
    }

    private static void find(int[][] matrix, int depth) {
        if (depth == 10) {
//            max = Math.max(max, biggest(matrix));
            int biggest = biggest(matrix);
            if (max < biggest) {
                max = biggest;
                mm = matrix;

            }

            return;
        }

        find(right(deepCopy(matrix)), depth + 1);
        find(up(deepCopy(matrix)), depth + 1);
        find(down(deepCopy(matrix)), depth + 1);
        find(left(deepCopy(matrix)), depth + 1);

    }

    private static int[][] deepCopy(int[][] matrix) {
        int[][] copy = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, n);
        }

        return copy;
    }

    private static int[][] right(int[][] m) {
        for (int i = 0; i < n; i++) {

            int location = n-1;
            int block = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (m[i][j] == 0) {
                    continue;
                }
                int value = m[i][j];

                // 0 이면 그 자리에 위치해
                // 같으면 합쳐
                // 다르면 다음꺼로 가
                if (location != n-1 && block == m[i][j]) {
                    m[i][location+1] *=2;
                    m[i][j] = 0;
                    block = 0;
                }
                else if(m[i][location] == 0){
                    m[i][location] = value;
                    m[i][j] = 0;
                    block = value;
                    location --;
                }else {
                    block = m[i][location];
                    location --;
                }

            }
        }
        return m;
    }

    private static int[][] left(int[][] m) {
        for (int i = 0; i < n; i++) {

            int location = 0;
            int block = 0;
            for (int j = 0; j < n; j++) {
                if (m[i][j] == 0) {
                    continue;
                }
                int value = m[i][j];

                if (location != 0 && block == m[i][j]) {
                    m[i][location-1] *=2;
                    m[i][j] = 0;
                    block = 0;
                }else if(m[i][location] == 0){
                    m[i][location] = value;
                    m[i][j] = 0;
                    block = value;
                    location ++;
                }else {
                    block = m[i][location];
                    location ++;
                }

            }
        }
        return m;
    }

    private static int[][] up(int[][] matrix) {
        for (int i = 0; i < n; i++) {

            int location = 0;
            int block = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[j][i] == 0) {
                    continue;
                }

                int value = matrix[j][i];

                if (location != 0 && block == value) {
                    matrix[location-1][i] *=2;
                    matrix[j][i] = 0;
                    block = 0;
                }else if(matrix[location][i] == 0){
                    matrix[location][i] = value;
                    matrix[j][i] = 0;
                    block = value;
                    location ++;
                }else {
                    block = matrix[location][i];
                    location ++;
                }

            }
        }
        return matrix;
    }

    private static int[][] down(int[][] matrix) {
        for (int i = 0; i < n; i++) {

            int location = n-1;
            int block = 0;
            for (int j = n-1; j >=0; j--) {
                if (matrix[j][i] == 0) {
                    continue;
                }

                int value = matrix[j][i];

                if (location != n-1 && block == value) {
                    matrix[location+1][i] *=2;
                    matrix[j][i] = 0;
                    block = 0;
                }else if(matrix[location][i] == 0){
                    matrix[location][i] = value;
                    matrix[j][i] = 0;
                    block = value;
                    location --;
                }else {
                    block = matrix[location][i];
                    location --;
                }

            }
        }
        return matrix;
    }
}