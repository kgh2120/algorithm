package Inflearn.bfsdfs;

import java.util.Scanner;

public class Inflearn_8_4_DuplicatePermutation {

    int index, lim;
    int max = Integer.MIN_VALUE;

    static class Problem{
        int score;
        int time;

        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }


    public void DFS(int now, int time,int score, Problem[] arr) {
        if(time > lim) return;

        if (now == index-1) {
            max = Math.max(max,score);
            return;
        }
        DFS(now+1,time+arr[now+1].time, score + arr[now+1].score, arr);
        DFS(now + 1, time, score, arr);
    }
    public static void main(String[] args) {
        Inflearn_8_4_DuplicatePermutation m = new Inflearn_8_4_DuplicatePermutation();
        Scanner sc = new Scanner(System.in);

        m.index = sc.nextInt();
        m.lim = sc.nextInt();
        Problem[] arr = new Problem[m.index];
        for (int i = 0; i < m.index; i++) {
            arr[i] = new Problem(sc.nextInt(),sc.nextInt());
        }

        m.DFS(-1,0,0,arr);
        System.out.println(m.max);

    }
}
