import java.util.*;
import java.io.*;



public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static char[][] classRoom;

    static int[][] deltas = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    static int numberOfCase;

    public static void main(String[] args) throws Exception {
        // 코드를 작성해주세요
        classRoom = new char[5][];
        for (int i = 0; i < 5; i++) {
            classRoom[i] = input.readLine().toCharArray();
        }

        boolean[][] selected = new boolean[5][5];

        combination(0,0,selected,0);
//
        System.out.println(numberOfCase);

        
    }


    static void checkIsAllConnected(boolean[][] selected){

        Coordinate starting = null;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(selected[i][j]){
                    starting = new Coordinate(i, j);
                    break;
                }
            }
        }

        if(starting == null) return;


        // 시작지점부터 dfs 진행하기

        boolean[][] visited = new boolean[5][5];
        visited[starting.row][starting.col] = true;



        int result = dfs(starting.row, starting.col, selected, visited);
        if (result == 7) {
            numberOfCase++;

        }
    }

    static int dfs(int row, int col, boolean[][] selected, boolean[][]visited) {

        int chain = 1;
        for (int[] delta : deltas) {
            int nr = row + delta[0];
            int nc = col + delta[1];

            if (isIn(nr, nc) && selected[nr][nc] && !visited[nr][nc]) {
                visited[nr][nc] = true;
                chain += dfs(nr,nc,selected,visited);

            }
        }
        return chain;
    }


    static void combination(int index, int depth, boolean[][] selected, int numberOfDasom) {
        if (depth == 7) {

            // 이다솜파 숫자 체크
            if(numberOfDasom < 4) return;
            // 서로 연결되어있는지 체크

            checkIsAllConnected(selected);
            return;
        }

        for (int i = index; i < 25; i++) {
            Coordinate coordinate = convertIndexToCoordinate(i);
            selected[coordinate.row][coordinate.col] = true;
            combination(i+1, depth+1, selected, isDasom(classRoom[coordinate.row][coordinate.col]) ? numberOfDasom+1 : numberOfDasom);
            selected[coordinate.row][coordinate.col] = false;
        }


    }

    static boolean isDasom(char student) {
        return student == 'S';
    }


    static Coordinate convertIndexToCoordinate(int index){
        return new Coordinate(index);
    }

    static boolean isIn(int row, int col) {
        return row >= 0 && row < 5 && col >= 0 && col < 5;
    }

    static class Coordinate{
        int row;
        int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Coordinate(int index) {

            this.row = index/5;
            this.col = index%5;

        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }
}
