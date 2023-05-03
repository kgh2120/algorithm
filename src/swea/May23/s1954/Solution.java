package swea.May23.s1954;

import java.util.Scanner;

class Solution
{
    static final int RIGHT = 0;
    static final int DOWN = 1;
    static final int LEFT  =2;
    static final int UP = 3;
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append("#").append(test_case).append("\n");
            int k = sc.nextInt();
            snail(k);
        }
        System.out.println(sb);
    }

    public static void snail(int k){

        int [][] matrix = new int[k][k];
        int direction = 0;
        int r = 0;
        int c = 0;
        int number = 1;
        while(number <= k*k){
            if(direction == RIGHT){
                while(true){
                    if(c == k ){
                        c--;
                        r++;
                        break;
                    }
                    if(matrix[r][c] !=0){
                        c--;
                        r++;
                        break;
                    }

                    matrix[r][c++] = number;
                    number++;
                }
            }else if(direction == DOWN){
                while(true){
                    if(r == k){
                        r--;
                        c--;
                        break;
                    }
                    if(matrix[r][c] !=0){
                        r--;
                        c--;
                        break;
                    }


                    matrix[r++][c] = number++;
                }
            }else if(direction == LEFT){
                while(true){
                    if(c == -1){
                        c++;
                        r--;
                        break;
                    }
                    if(matrix[r][c] !=0){
                        c++;
                        r--;
                        break;
                    }


                    matrix[r][c--] = number++;
                }
            }else{
                while(true){
                    if(r == -1 ){
                        r++;
                        c++;
                        break;
                    }
                    if(matrix[r][c] !=0){
                        r++;
                        c++;
                        break;
                    }

                    matrix[r--][c] = number++;
                }
            }
            direction = (direction+1) % 4;
        }
        for(int i = 0; i<k;i++){
            for(int j = 0; j<k; j++){
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }



    }
}