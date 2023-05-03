package beak.prev.brootForce;

import java.util.Scanner;

/*
    문제 : 체스판 다시 칠하기
    난이도 : 실버 5
    특징 : 나는 존나 어려웠던거 같은데, 난이도가 존나낮다..
 */
public class p1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y =  sc.nextInt();
        String[][] input = new String[x][y];
        int[][] BWDP = new int[x][y];
        int[][] WBDP = new int[x][y];
        boolean[][] isBW = new boolean[x][y];
        boolean[][] isWB = new boolean[x][y];

        for(int i = 0; i<x; i++)
            for(int j = 0; j<y; j++){
                isBW[i][j] = false;
                isWB[i][j] = false;
            }

        for(int i = 0; i<x; i++){
            String text = sc.next();
            for(int j = 0; j<y;j++)
                input[i][j] = text.charAt(j)+"";
        }

        String[][] modelBW = new String[x][y];
        String[][] modelWB = new String[x][y];


        for(int i = 0; i<x; i++)
            for(int j = 0; j<y; j++){
                if((i+j)%2==0){
                    modelBW[i][j] = "B";
                    modelWB[i][j] = "W";
                }else{
                    modelBW[i][j] = "W";
                    modelWB[i][j] = "B";
                }
            }
        setDPTable(input, modelBW, BWDP,isBW);
        setDPTable(input, modelWB, WBDP,isWB);



        int result = findMin(BWDP,WBDP,isBW,isWB);
        System.out.println(result);
    }

    private static void setDPTable(String[][] input, String[][] Model, int[][] DP, boolean[][] isAccessed){
        for(int i = 0; i<= input.length-8;i++)
            for(int j =0; j<=input[0].length-8;j++){
                DP[i][j] = diff(input,Model,i,j);
                isAccessed[i][j] = true;
            }



    }

    private static int diff(String[][]input, String[][]Model, int startX, int startY){

        int diffCount = 0;
        for(int i = startX; i<startX+8;i++)
            for(int j=startY;j<startY+8;j++)
                if(input[i][j].compareTo(Model[i][j])!=0){
                    diffCount++;
                }

        return diffCount;
    }

    private static int findMin(int[][] bw, int[][] wb, boolean[][] isBW, boolean[][] isWB) {
        int min = 9999;
        for(int i = 0; i<bw.length;i++){
            for(int j =0; j<bw[0].length;j++){
                if(isBW[i][j] && !isWB[i][j]){
                    if(min > bw[i][j])
                        min = bw[i][j];
                }
                else if(isWB[i][j] && !isBW[i][j]){
                    if(min > wb[i][j])
                        min = wb[i][j];
                }
                else if(isBW[i][j] && isWB[i][j])
                    if(min > Math.min(bw[i][j],wb[i][j]))
                        min = Math.min(bw[i][j],wb[i][j]);
            }
        }


        return min;
    }
}
