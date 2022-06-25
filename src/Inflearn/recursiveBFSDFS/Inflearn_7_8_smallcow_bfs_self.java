package Inflearn.recursiveBFSDFS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Inflearn_7_8_smallcow_bfs_self {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();

        Deque<Integer> queue = new ArrayDeque<>();
        int level = 0;
        queue.add(n);
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int p = queue.pop();

                if (p == s) {
                    System.out.println(level);
                    return;
                }
                if (p > s)
                    queue.add(p - 1);
                if(s-p <5)
                    queue.add(p + 1);
                if (p < s)
                    queue.add(p + 5);
            }
            level++;

        }
    }
}
