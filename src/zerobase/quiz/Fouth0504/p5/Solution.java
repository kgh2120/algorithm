package zerobase.quiz.Fouth0504.p5;

import java.util.*;

class Solution {
    /*
     buildings 안에는 x좌표와 높이가 주어진다.
    */
    public int[][] solution(int[][] buildings) {
        final int UP = 1;
        final int RIGHT = 2;
        final int DOWN = 3;
        int[][] answer = {};
        int[][] matrix = new int[10001][10001];
        for(int i = 0; i< buildings.length; i++){
            int left = buildings[i][0];
            int right = buildings[i][1];
            int h = buildings[i][2];
            for(int j = 0; j< h; j++){
                matrix[j][left] = 1;
                matrix[j][right] = 1;
            }
            for(int j = left; j <= right; j++){
                matrix[h][j] = 1;
            }
        }




        // 이동
        int x = 0;
        int y = 0;
        boolean flag = false;
        List<int[]> b = new ArrayList<>();
        int c = 0;
        int direction = RIGHT;
        while(true){
            c++;
            if(c >= 10001 * 10001){
                break;
            }
            if(x == 10001)
                break;
            if(matrix[y][x] == 0){
                direction = RIGHT;
                x++;
                continue;
            }
            if(matrix[y][x] == 1){
                if(y != matrix.length-1 && matrix[y+1][x] == 1 && direction != DOWN){ // check
                    y++;
                    flag = true;
                    direction = UP;
                }else if(x != matrix.length-1 && matrix[y][x+1]==1){
                    direction  = RIGHT;
                    if(flag){

                        int[] arr = {x,y};
                        b.add(arr);
                    }
                    x++;
                    flag = false;

                }else if(y != 0 && matrix[y-1][x] == 1){
                    direction = DOWN;
                    y--;
                    flag=true;
                }
                else if(y == 0){
                    direction  = RIGHT;
                    if(flag){

                        int[] arr = {x,y};
                        b.add(arr);
                    }
                    x++;
                    flag = false;
                }
            }

        }

        answer = new int[b.size()][2];
        for (int i = 0; i < b.size(); i++) {
            answer[i] = b.get(i);
        }

        return answer;
    }
}