import java.util.Scanner;

public class Main {

    int[][] matrix;
    int ans = Integer.MAX_VALUE;
    int nr=1;
    int nc=1;
    int move;
    public boolean move(int code) {
        int row = 0;
        int col = 0;

        switch (code) {
            case 1 :
                // 1 : 상
                row = nr-1;
                col = nc;
                if(row <= 0 || matrix[row][col] == 1 || matrix[row][col] == 9)
                    return false;
                break;
            case 2 :
                // 2 : 하
                row = nr+1;
                col = nc;
                if(row >= matrix.length || matrix[row][col] == 1 || matrix[row][col] == 9)
                    return false;
                    break;
            case 3 :
                // 3 : 좌
                row = nr;
                col = nc-1;
                if(col <= 0 || matrix[row][col] == 1 || matrix[row][col] == 9)
                    return false;
                break;

            case 4:
                // 4 : 우
                row = nr;
                col = nc+1;
                if(col >= matrix[row].length || matrix[row][col] == 1 || matrix[row][col] == 9)
                    return false;
                break;
        }
        matrix[nr][nc] = 9;
        nr = row;
        nc = col;

        return true;
    }

    public void showMatrix() {
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void DFS() {
        if(move > ans) return;
        if (nr == 7 && nc == 7) {
            ans = Math.min(ans,move);
        }else{
            for (int i = 1; i <= 4; i++) {
                int pRow = nr; int pCol = nc;
                if (move(i)) {
                    move++;
                    DFS();
                    matrix[pRow][pCol] = 0;
                    nr = pRow; nc = pCol;
                    move--;
                }
            }



        }
    }





    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        m.matrix = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                m.matrix[i][j] = sc.nextInt();
            }
        }
        m.DFS();
        System.out.println(m.ans == Integer.MAX_VALUE ? -1 : m.ans);

    }




}