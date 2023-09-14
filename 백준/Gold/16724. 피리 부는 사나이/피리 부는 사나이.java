import java.io.*;
import java.math.BigInteger;
import java.util.*;



public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static int nOfCycle;

    static int n,m;
    static char[][] matrix;

    static boolean [][] visited;


    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        matrix = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j]) continue;
                if(move(i,j))
                    nOfCycle++;
            }
        }
        System.out.println(nOfCycle);
    }

    private static boolean move(int i, int j){
        Set<Integer> thisTurnVisited = new HashSet<>();
        while (true) {
            visited[i][j] = true;
            thisTurnVisited.add(convertPos(i,j));
            char command = matrix[i][j];
            switch (command) {
                case 'D' :
                    i++;
                    break;
                case 'U' :
                    i--;
                    break;
                case 'L' :
                    j--;
                    break;
                case 'R' :
                    j++;
                    break;
            }
            // 이미 탄 경우
            if(thisTurnVisited.contains(convertPos(i,j))) return true;
            if(visited[i][j]) return false;
        }

    }

    private static int convertPos(int i,int j) {
        return i*10000 + j;
    }


}