package Inflearn.bfsdfs;

import java.util.Scanner;

public class Inflearn_8_8_combination {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();

        DFS(0, n, 0, l, "");

    }

    public static void DFS(int i,int tn, int nl, int tl, String rt) {
        if(i>tn) return;
        if (nl == tl) {
            System.out.println(rt);
        }else{
            for (int j = i+1; j <= tn; j++) {
                DFS(j,tn,nl+1,tl,rt+" "+j);
            }
        }
    }

}