package beak.prev.backtracking;

import java.util.Scanner;

public class P_15649_NM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        Backtracking(x,y,0,"");
    }

    public static void Backtracking(int x, int y, int now, String result) {
        if (y == now) {
            System.out.println(result);
        }else {
            for (int i = 1; i <=x ; i++) {
                if(!result.contains(i+""))
                    Backtracking(x,y,now+1,result+i+ " ");
            }
        }
    }
}
