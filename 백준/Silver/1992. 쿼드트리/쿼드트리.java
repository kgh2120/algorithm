import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static char[][] matrix;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        System.out.println(dnq(0,0,n));

    }
    private static String dnq(int sr, int sc, int size) {
        int sum = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(matrix[sr+i][sc+j] == '1')
                    sum++;
                sb.append(matrix[sr+i][sc+j]);
            }
        }

        if (sum == 0) {
            return "0";
        } else if (sum == size * size) {
            return "1";
        } else {
            StringBuilder temp = new StringBuilder();
            temp.append("(");
            int half = size/2;
            temp.append(dnq(sr,sc,half));
            temp.append(dnq(sr,sc+half,half));
            temp.append(dnq(sr+half,sc,half));
            temp.append(dnq(sr+half,sc+half,half));
            temp.append(")");
            return temp.toString();
        }
    }


}