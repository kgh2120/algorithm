import java.io.*;
import java.util.*;


/**
 *
 */
public class Main{

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;

    static int[][] origin;

    static int max;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        origin = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < n; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, origin);
        System.out.println(max);

    }


    static void dfs(int turn, int[][] matrix){

        if(turn == 5)
            return;


        dfs(turn+1, up(matrix));
        dfs(turn+1, down(matrix));
        dfs(turn+1, left(matrix));
        dfs(turn+1, right(matrix));


    }

    static void bfs(){
        Queue<int[][]> q = new ArrayDeque<>();
        q.add(origin);
        int turn = 0;
        while (turn++ < 5) {

            int size = q.size();
            while (size-- > 0) {
                int[][] current = q.poll();

                // up
                int[][] up = up(current);
                q.add(up);
//                printMatrix(up);
                // down
                int[][] down = down(current);
                q.add(down);
//                printMatrix(down);
                // left
                int[][] left = left(current);
                q.add(left);
//                printMatrix(left);
                // right
                int[][] right = right(current);
                q.add(right);
//                printMatrix(right);
            }
        }

    }

    static int[][] up(int[][] origin){
        int[][] up = cloneMatrix(origin);
        boolean [][] visited = new boolean[n][n];

        // 위에서부터 땡기기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(up[i][j] == 0) continue;
                max = Math.max(max, up[i][j]);

                for (int k = i-1; k >= 0; k--) {
                    // 쭈욱 전진함.
                    // 가다가 막히면, 값이 동일하면 합치기, 아니면 거기 +1에 위치하기.
                    if (up[k][j] != 0) {
                        if (up[k][j] == up[i][j]) {
                            if (!visited[k][j]) {
                                up[k][j] += up[i][j];
                                up[i][j] = 0;
                                max = Math.max(max, up[k][j]);
                                visited[k][j] = true;
                            } else {
                                up[k+1][j] = up[i][j];
                                up[i][j] = 0;
                            }
                        } else {
                            if(k+1 != i){
                                up[k+1][j] = up[i][j];
                                up[i][j] = 0;
                            }
                        }
                        break;
                    }
                    // 안걸리면, 즉 0까지 가는 경우
                    if (k == 0) {
                        up[k][j] = up[i][j];
                        up[i][j] = 0;
                    }
                }
            }

        }

//        System.out.println("UP");
//        System.out.println("---BEFORE ---");
//        printMatrix(origin);
//        System.out.println("---AFTER ---");
//        printMatrix(up);

        return up;
    }

    static int[][] down(int[][] origin){
        int[][] clone = cloneMatrix(origin);
        boolean [][] visited = new boolean[n][n];
        // 위에서부터 땡기기
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if(clone[i][j] == 0) continue;
                max = Math.max(max, clone[i][j]);

                for (int k = i+1; k < n; k++) {
                    // 쭈욱 전진함.
                    // 가다가 막히면, 값이 동일하면 합치기, 아니면 거기 +1에 위치하기.
                    if (clone[k][j] != 0) {
                        if (clone[k][j] == clone[i][j]) {
                            if (!visited[k][j]) {
                                clone[k][j] += clone[i][j];
                                clone[i][j] = 0;
                                max = Math.max(max, clone[k][j]);
                                visited[k][j] = true;
                            } else {
                                clone[k-1][j] = clone[i][j];
                                clone[i][j] = 0;
                            }
                        } else {
                            if(k-1 != i){
                                clone[k-1][j] = clone[i][j];
                                clone[i][j] = 0;
                            }
                        }
                        break;
                    }
                    // 안걸리면, 즉 0까지 가는 경우
                    if (k == n-1) {
                        clone[k][j] = clone[i][j];
                        clone[i][j] = 0;
                    }
                }
            }

        }
//        System.out.println("DOWN");
//        System.out.println("---BEFORE ---");
//        printMatrix(origin);
//        System.out.println("---AFTER ---");
//        printMatrix(clone);

        return clone;
    }

    static int[][] right(int[][] origin){
        int[][] clone = cloneMatrix(origin);
        boolean [][] visited = new boolean[n][n];
        // 위에서부터 땡기기
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {

                    if(clone[j][i] == 0) continue;
                    max = Math.max(max, clone[j][i]);

                    for (int k = i+1; k < n; k++) {
                        // 쭈욱 전진함.
                        // 가다가 막히면, 값이 동일하면 합치기, 아니면 거기 +1에 위치하기.
                        if (clone[j][k] != 0) {
                            if (clone[j][k] == clone[j][i]) {
                                if (!visited[j][k]) {
                                    clone[j][k] += clone[j][i];
                                    clone[j][i] = 0;
                                    max = Math.max(max, clone[j][k]);
                                    visited[j][k] = true;
                                } else {
                                    clone[j][k-1] = clone[j][i];
                                    clone[j][i] = 0;
                                }
                            } else {
                                if (k - 1 != i) {
                                    clone[j][k-1] = clone[j][i];
                                    clone[j][i] = 0;
                                }
                            }
                            break;
                        }
                        // 안걸리면, 즉 0까지 가는 경우
                        if (k == n-1) {
                            clone[j][k] = clone[j][i];
                            clone[j][i] = 0;
                        }
                    }
                }
        }
//        System.out.println("RIGHT");
//        System.out.println("---BEFORE ---");
//        printMatrix(origin);
//        System.out.println("---AFTER ---");
//        printMatrix(clone);

        return clone;
    }

    static int[][] left(int[][] origin){
        int[][] clone = cloneMatrix(origin);
        boolean [][] visited = new boolean[n][n];
        // 위에서부터 땡기기
        for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {

                if(clone[j][i] == 0) continue;
                max = Math.max(max, clone[j][i]);

                for (int k = i-1; k >= 0; k--) {
                    // 쭈욱 전진함.
                    // 가다가 막히면, 값이 동일하면 합치기, 아니면 거기 +1에 위치하기.
                    if (clone[j][k] != 0) {
                        if (clone[j][k] == clone[j][i]) {
                            if (!visited[j][k]) {

                                clone[j][k] += clone[j][i];
                                clone[j][i] = 0;
                                max = Math.max(max, clone[j][k]);
                                visited[j][k] = true;
                            } else {
                                clone[j][k+1] = clone[j][i];
                                clone[j][i] = 0;
                            }
                        } else {
                            if (k + 1 != i) {
                                clone[j][k+1] = clone[j][i];
                                clone[j][i] = 0;
                            }
                        }
                        break;
                    }
                    // 안걸리면, 즉 0까지 가는 경우
                    if (k == 0) {
                        clone[j][k] = clone[j][i];
                        clone[j][i] = 0;
                    }
                }
            }
        }
//        System.out.println("LEFT");
//        System.out.println("---BEFORE ---");
//        printMatrix(origin);
//        System.out.println("---AFTER ---");
//        printMatrix(clone);

        return clone;
    }

    static int[][] cloneMatrix(int[][] matrix) {
        int[][] clone = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            clone[i] = new int[matrix[i].length];
             System.arraycopy(matrix[i], 0, clone[i], 0, matrix[i].length);
        }
        return clone;
    }

    static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }

}