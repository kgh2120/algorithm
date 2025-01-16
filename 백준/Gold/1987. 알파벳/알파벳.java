import java.util.*;
import java.io.*;
public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int maxRow;
    static int maxCol;

    static int [][] deltas = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    static int[][] map;
    // 26

    static int max = 0;

    static int[][] visited;


    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요

        st = new StringTokenizer(input.readLine());
        maxRow = Integer.parseInt(st.nextToken());
        maxCol = Integer.parseInt(st.nextToken());

        map = new int[maxRow][maxCol];
        visited = new int[maxRow][maxCol];
        for(int i = 0; i<maxRow; i++){
            String line = input.readLine();
            for(int j = 0; j<maxCol; j++)
                map[i][j] = line.charAt(j) - 'A';
        }


        dfs(0,0, 1, 1 << map[0][0]);
        System.out.println(max);

    }

    static void dfs(int row, int col, int score, int selectedBit ){
        // 해당 부분에 똑같은 조건으로 온 적 있거나 이미 모든 알파벳을 모은 경우는 pass
        if(visited[row][col] == selectedBit ||  max == 26){
            return;
        }

        visited[row][col] = selectedBit;


        for(int [] delta : deltas){
            int nr = row + delta[0];
            int nc = col + delta[1];
            // 범위 내에 있는지, 방문한 적 있는지(bit로 체크)
            if(isIn(nr,nc) && (selectedBit & (1 << map[nr][nc])) == 0){
                dfs(nr,nc, score+1, selectedBit | (1 << map[nr][nc]));

            }
        }

        max = Math.max(max,score);
    }

    static boolean isIn(int row, int col){
        return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
    }
}

