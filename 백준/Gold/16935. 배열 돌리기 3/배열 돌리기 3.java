import java.io.*;
import java.util.*;


/**
 * @author 김규현
 * @performance
 * @category #구현
 * @note N * M 배열에 6가지 연산을 잘 적용시켜보는 문제이다.
 * <p>
 * 첫번째 연산은 상하 반전 연산으로, 가운데를 기준으로 위아래를 바꿔주는 작업을 한다.
 * N이 홀수일때와 짝수일 때 처리가 살짝 다르다는 것을 인지해야 할 듯 싶다.
 * <p>
 * 두번째 연산은 좌우 반전으로 첫번째 연산과 동일하지만 M을 기준으로 한다는 차이가 있다.
 * <p>
 * 세번째 연산은 오른쪽으로 90도 회전시키는 연산이다.
 * <p>
 * 네번째 연산은 왼쪽으로 90도 회전시키는 연산이다.
 * <p>
 * 5,6번 연산은 배열을 1/4로 나누고 5번은 오른쪽으로 90도 회전, 6번은 왼쪽으로 90도 회전하는 느낌이다.
 * <p>
 * 2 <= N,M <= 100 // n과 m은 짝수이다.
 * 1 <= R <= 1000
 * 이다. 전부 효율성을 따지지 않고 연산을 한다고 하더라도 10^7로 2초 내에 충분히 가능해보인다.
 * @see https://www.acmicpc.net/problem/16935
 * @since 2023-08-09
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n, m, r;
    static String[] operations;
    static String[][] matrix;


    public static void main(String[] args) throws Exception {
        //br = new BufferedReader(new StringReader("6 8 1\n" + "3 2 6 3 1 2 9 7\n" + "9 7 8 2 1 4 5 3\n" + "5 9 2 1 9 6 1 8\n" + "2 1 3 8 6 3 9 2\n" + "1 3 2 8 7 9 2 1\n" + "4 5 1 9 8 2 1 3\n" + "6"));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        matrix = new String[n + 1][m + 1];
        operations = new String[r];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = st.nextToken();
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++)
            operations[i] = st.nextToken();

        for (String operation : operations)
            operation(operation);



        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++)
                sb.append(matrix[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void operation(String ops) {
        switch (ops) {
            case "1":
                reverseUpDown();
                break;
            case "2":
                reverseLeftRight();
                break;
            case "3":
                rotateRight();
                break;
            case "4":
                rotateLeft();
                break;
            case "5":
                action5();
                break;
            case "6": action6();
                break;
        }
    }

    private static void reverseUpDown() {
        // 가운데(N/2)를 기준으로 증감값으로 서로 swap해준다.
        int n = matrix.length-1;
        int m = matrix[0].length-1;
        for (int i = 1; i <= n / 2; i++) {
            int left = n / 2 - (i - 1);
            for (int j = 1; j <= m; j++) {
                int right = n / 2 + i;
                String temp = matrix[left][j];
                matrix[left][j] = matrix[right][j];
                matrix[right][j] = temp;
            }
        }
    }


    private static void reverseLeftRight() {
        // 가운데(M/2)를 기준으로 증감값으로 서로 swap해준다.
        int n = matrix.length-1;
        int m = matrix[0].length-1;
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m / 2; j++) {
                int left = m / 2 - (j - 1);
                int right = m / 2 + j;
                String temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
            }
        }
    }

    private static void rotateRight() {

        int n = matrix.length-1;
        int m = matrix[0].length-1;
        String[][] temp = new String[m + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                temp[j][n - (i - 1)] = matrix[i][j];
            }
        }
        matrix = temp;
    }

    private static void rotateLeft() {

        int n = matrix.length-1;
        int m = matrix[0].length-1;
        String[][] temp = new String[m + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                temp[m - (j - 1)][i] = matrix[i][j];
            }
        }
        matrix = temp;
    }

    private static void action5() {
        String[][] temp = new String[matrix.length][matrix[0].length];
        int n = matrix.length-1;
        int m = matrix[0].length-1;
        // 2 1 3 4 순으로 채운다.
        // r : 1 ~ n/2 c : 1 + 2/m ~ m까지

        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; j <= m/2; j++) {
                temp[i][j +  m/2] = matrix[i][j];
            }
        }

        // 3 채우기
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; j <= m/2; j++) {
                temp[i +n/2][j + m/2] = matrix[i][j +  m/2];
            }
        }

        // 4 채우기
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; j <= m/2; j++) {
                temp[i + n/2][j] = matrix[i + n/2][j +  m/2];
            }
        }

        // 1 채우기
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; j <= m/2; j++) {
                temp[i][j] = matrix[i + n/2][j];
            }
        }
        matrix = temp;
    }

    private static void action6() {
        String[][] temp = new String[matrix.length][matrix[0].length];
        int n = matrix.length-1;
        int m = matrix[0].length-1;
        // 2 1 3 4 순으로 채운다.
        // r : 1 ~ n/2 c : 1 + 2/m ~ m까지

        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; j <= m/2; j++) {
                temp[i][j] = matrix[i][j+ m/2];
            }
        }

        // 3 채우기
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; j <= m/2; j++) {
                temp[i ][j + m/2] = matrix[i+n/2][j +  m/2];
            }
        }

        // 4 채우기
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; j <= m/2; j++) {
                temp[i + n/2][j+  m/2] = matrix[i + n/2][j ];
            }
        }

        // 1 -> 4
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; j <= m/2; j++) {
                temp[i + n/2][j] = matrix[i][j];
            }
        }
        matrix = temp;
    }

}