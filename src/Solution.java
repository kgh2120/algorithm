import java.util.Arrays;

class Solution {
    public int solution(int[][] maze) {
        final int mod = 1007;
        long answer = 0;
        long [][] matrix = new long[maze.length][maze[0].length];

        int r = 0;
        int c = 0;
        for(int i = 0; i<maze[0].length;i++){
            if(maze[0][i] == 1)
                break;
            if(maze[0][i] == 2){
                r = 0;
                c = i;
                matrix[0][i] = 1;
                break;
            }
            matrix[0][i] = 1;
        }
        for(int i = 0; i<maze.length;i++){
            if(maze[i][0] == 1)
                break;
            if(maze[i][0] == 2){
                r = i;
                c = 0;
                matrix[i][0] = 1;
                break;
            }
            matrix[i][0] = 1;
        }

        for(int i = 1; i<maze.length; i++){
            for(int j = 1; j<maze[0].length; j++){
                if(maze[i][j] == 1){
                    matrix[i][j] = 0;
                    continue;
                }
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
                // matrix[i][j] = matrix[i-1][j] % mod  + matrix[i][j-1] % mod;
                matrix[i][j] %= mod;

                if(maze[i][j] == 2){
                    r = i;
                    c = j;
                    break;
                }
            }
        }

        // if(matrix[r][c] == 0)
        //     return 0;



        long c1 = matrix[r][c];
        // 열쇠 부터 끝까지 다시 만들기

        for(int i = r; i < maze.length; i++){

            if(maze[i][c] == 1)
                break;
            matrix[i][c] = 1;
        }
        for(int i = c; i < maze[0].length; i++){
            if(maze[r][i] == 1)
                break;
            matrix[r][i] = 1;
        }


        for(int i = r+1; i<maze.length; i++){
            for(int j = c+1; j<maze[0].length; j++){
                if(maze[i][j] == 1){
                    matrix[i][j] = 0;
                    continue;
                }
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];

                // matrix[i][j] = matrix[i-1][j] % mod  + matrix[i][j-1] % mod;
                matrix[i][j] %= mod;
            }
        }
        c1 %= mod;

        answer = (matrix[maze.length-1][maze[0].length-1] * c1) % mod;



        return (int)answer;
    }

    public static void main(String[] args) {
        int [][] a = {{0, 1, 0,0}, {0, 2, 0,0}, {0,0,0, 0}};
        int solution = new Solution().solution(a);
        System.out.println(solution);
    }
}