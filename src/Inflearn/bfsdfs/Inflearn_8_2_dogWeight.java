package Inflearn.bfsdfs;

import java.util.Scanner;

public class Inflearn_8_2_dogWeight {

    int max = Integer.MIN_VALUE;

    public void DFS(int sum, int index, int n, int lim, int[]arr) {
        if(sum >= lim) return;


        // 종료조건
        if (index == n) {
            max = Math.max(max, sum);
            return;
        }
        //
        DFS(sum+arr[index],index+1,n,lim,arr); //현재 개를 넣는다
        //안넣는다
        DFS(sum,index+1,n,lim,arr);
    }



    public static void main(String[] args) {
        Inflearn_8_2_dogWeight m = new Inflearn_8_2_dogWeight();
        Scanner scanner = new Scanner(System.in);
        int lim = scanner.nextInt();
        int nOfDog = scanner.nextInt();
        int[] dogs = new int[nOfDog];
        for (int i = 0; i < nOfDog; i++) {
            dogs[i] = scanner.nextInt();
        }
        m.DFS(0,0,nOfDog,lim,dogs);

        System.out.println(m.max);



    }
}
