import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/**
 *  String에 점 , #으로 찍어서 도형인거 체크하고 그 도형의 사이즈를 구하는 문제
 *  도형이 닫힌 도형이면 안에 것 까지 사이즈로 취급해야 하고, 닫히지 않으면 그냥 개수로만 체크하기
 *  약간 바둑같은 느낌?
 *  BFS로 도형의 범위를 구하고, 닫힘 체크를 해야 했는데, 여기서 좀 꼬인듯.
 */
public class M2 {
    boolean [][] path;
    List<List<Cor>> maps;
    int answer = 0;
    public int solution(String[] grid) throws Exception {
        int row = grid.length;
        int col = grid[0].length();
        path = new boolean[row][col];
        maps = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i].charAt(j) == '#' && !path[i][j])
                    bfs(i,j,row,col, grid);
            }
        }


        return answer;
    }

    public void bfs(int row, int col, int maxRow, int maxCol, String[] grid){

        Queue<Cor> q = new LinkedList<>();
        q.add(new Cor(row,col));
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Cor> cors = new ArrayList<>();
        path[ row][ col] = true;

        Cor right = new Cor(0,0);
        Cor up = new Cor(0,0);
        Cor down = new Cor(0,0);
        Cor left = new Cor(0,0);


        while (!q.isEmpty()) {
            Cor cor = q.poll();
            cors.add(cor);

            if(cor.row > down.row)
                down.row = cor.row;
            if(cor.col > right.col)
                right.col = cor.col;
            if(cor.col < left.col)
                left.col = cor.col;
            if(cor.row < up.row)
                up.row = cor.row;
            List<Integer> integers = map.get(cor.row);
            if (integers == null) {
                map.put(cor.row, new ArrayList<>());
                integers = map.get(cor.row);
            }
            integers.add(cor.col);

            // 주변에 동료가 있으면 다 집어넣음.
            // 위
            add(maxRow, maxCol, q, cor, -1, 0,grid );
            // 좌상
            add(maxRow,maxCol,q,cor, -1,-1, grid) ;
            // 우상
            add(maxRow,maxCol,q,cor, -1,1, grid) ;
            //좌
            add(maxRow,maxCol,q,cor, 0,-1, grid) ;
            // 우
            add(maxRow,maxCol,q,cor, 0,1, grid) ;
            //좌하
            add(maxRow,maxCol,q,cor, +1,-1, grid) ;
            //하
            add(maxRow,maxCol,q,cor, +1,0, grid) ;
            //우하
            add(maxRow,maxCol,q,cor, +1,1, grid) ;
        }

        boolean reView = isChainedUp(grid, right, up, left);
        boolean d = isChainedDown(grid, right, down, left);
        boolean r = isChainedRight(grid, right, up, left, down);
        boolean l = isChainedleft(grid, right, up, left, down);

        // 아래


        if (reView || d || r || l) {
            answer += cors.size();
        } // 끊긴애
        else{
            Collection<List<Integer>> values = map.values();
            for (List<Integer> value : values) {
                Collections.sort(value);
                answer += value.get(value.size()-1) - value.get(0) +1;
            }
        }

    }

    private boolean isChainedUp(String[] grid, Cor right, Cor up, Cor left) {
        boolean first = false;
        boolean unchanied = false;
        boolean reView = false;

        // 위
        for (int i = left.col; i <= right.col; i++) {
            if(!first && grid[up.row].charAt(i)=='#')
                first = true;
            else if(first && grid[up.row].charAt(i)=='.')
                unchanied = true;
            else if(unchanied && grid[up.row].charAt(i)=='#')
                reView = true;
        }
        return reView;
    }
    private boolean isChainedDown(String[] grid, Cor right, Cor down, Cor left) {
        boolean first = false;
        boolean unchanied = false;
        boolean reView = false;

        // 위
        for (int i = left.col; i <= right.col; i++) {
            if(!first && grid[down.row].charAt(i)=='#')
                first = true;
            else if(first && grid[down.row].charAt(i)=='.')
                unchanied = true;
            else if(unchanied && grid[down.row].charAt(i)=='#')
                reView = true;
        }
        return reView;
    }

    private boolean isChainedRight(String[] grid, Cor right, Cor up, Cor left, Cor down) {
        boolean first = false;
        boolean unchanied = false;
        boolean reView = false;
        // 위
        for (int i = up.row; i <= down.row; i++) {
            if(!first && grid[i].charAt(right.col)=='#')
                first = true;
            else if(first && grid[i].charAt(right.col)=='.')
                unchanied = true;
            else if(unchanied && grid[i].charAt(right.col)=='#')
                reView = true;
        }
        return reView;
    }

    private boolean isChainedleft(String[] grid, Cor right, Cor up, Cor left, Cor down) {
        boolean first = false;
        boolean unchanied = false;
        boolean reView = false;
        // 위
        for (int i = up.row; i <= down.row; i++) {
            if(!first && grid[i].charAt(left.col)=='#')
                first = true;
            else if(first && grid[i].charAt(left.col)=='.')
                unchanied = true;
            else if(unchanied && grid[i].charAt(left.col)=='#')
                reView = true;
        }
        return reView;
    }


    private void add(int maxRow, int maxCol, Queue<Cor> q, Cor cor, int row, int col, String[] grid) {
        Cor move = move(cor, row, col, maxRow, maxCol, grid);
        if(move !=null)
            q.add(move);
    }

    public Cor move(Cor current, int row, int col, int maxRow, int maxCol, String[] grid){



        if (current.row + row >= 0 &&
                current.row + row < maxRow &&
                current.col + col >= 0 &&
                current.col + col < maxCol &&
                !path[current.row + row][current.col + col] &&
                grid[current.row + row].charAt(current.col + col) == '#') {


            path[current.row + row][current.col + col] = true;
            return new Cor(current.row + row, current.col + col);
        }
        return null;
    }

    class Cor{
        int row;
        int col;

        public Cor(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws Exception {


        String[] grid = {
                "####",
                "##.#",
                ".#.#"};

        System.out.println(new M2().solution(grid));
    }
}
