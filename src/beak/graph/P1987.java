package beak.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


/*

    https://www.acmicpc.net/problem/1987
    그래프 탐색 문제 골드 4
    길찾기 문제, dfs로 풀어봤다.
    근데 메서드를 짜다가 계속 파라미터에서 누락이 발생함.
    그거 때문에 지금 몇번째 틀리는데 진짜 짜증난다.

 */

public class P1987 {

    int max = Integer.MIN_VALUE;
    char[][] matrix;
    Set<Character> set = new HashSet<>();
    int r;
    int c;
    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        matrix = new char[r][c];
        for(int i = 0; i<r; i++){
            String col = br.readLine();
            for(int j =0; j<c; j++){
                matrix[i][j] = col.charAt(j);
            }
        }
        set.add(matrix[0][0]);
        dfs(1,0,0);
        System.out.println(max);
    }

    private boolean canMove(int row, int col){
        if(row >=0 && row < r && col >= 0 && col <c)
            return !set.contains(matrix[row][col]);
        return false;
    }

    private void dfs(int count, int row, int col){
        if(canMove(row-1,col)){
            set.add(matrix[row-1][col]);
            dfs(count+1,row-1,col);
            set.remove(matrix[row-1][col]);
        }
        if(canMove(row+1,col)){
            set.add(matrix[row+1][col]);
            dfs(count+1,row+1,col);
            set.remove(matrix[row+1][col]);
        }
        if(canMove(row,col-1)){
            set.add(matrix[row][col-1]);
            dfs(count+1,row,col-1);
            set.remove(matrix[row][col-1]);
        }
        if(canMove(row,col+1)){
            set.add(matrix[row][col+1]);
            dfs(count+1,row,col+1);
            set.remove(matrix[row][col+1]);
        }

        max = Math.max(count, max);

    }


    public static void main(String[] args) throws Exception {
        new P1987().solution();
    }

}
