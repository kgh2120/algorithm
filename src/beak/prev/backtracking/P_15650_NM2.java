package beak.prev.backtracking;

import java.util.Scanner;

public class P_15650_NM2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        Backtracking(x,y,1,0,"");
    }

    public static void Backtracking(int x, int y,int nowNum, int now, String result) {
        if (y == now) {
            System.out.println(result);
        }else {
            for (int i = nowNum; i <=x ; i++) {
                    Backtracking(x,y,i+1,now+1,result+i+ " ");
            }
        }
    }


}