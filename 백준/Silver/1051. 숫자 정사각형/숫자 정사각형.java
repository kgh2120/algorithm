import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<Integer, List<Point>> map;
    static int max;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        max = 1;
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }


        // 2*2 ~ min(n,m)^2 까지 살펴보기

        loop : for (int k = 1; k < Math.min(n,m); k++) {
            for (int i = 0; i < n-k; i++) {
                //  i,j     i,j+k
                //  i+k,j   i+k,j+k 같다면   max = k+1
                //
                //
                for (int j = 0; j < m-k; j++) {
                    if (matrix[i][j] == matrix[i][j + k] &&
                            matrix[i][j] == matrix[i + k][j] &&
                            matrix[i][j] == matrix[i + k][j + k]) {
                        max = k+1;
                        continue loop;
                    }

                }
            }

        }
        System.out.println(max * max);

    }


}