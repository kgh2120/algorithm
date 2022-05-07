package Inflearn.Sorting;

import java.util.LinkedList;
import java.util.Scanner;

public class Inflearn_6_4_LRU {
    public static void answerFirst(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sizeLimit = sc.nextInt();
        int nOfTask = sc.nextInt();

        LinkedList<Integer> nodes = new LinkedList<>();
        for (int i = 0; i < sizeLimit; i++) {
            nodes.add(0);
        }
        for (int i = 0; i < nOfTask; i++) {
            working(nodes,sc.nextInt(),sizeLimit);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer node : nodes) {
            sb.append(node).append(" ");
        }
        System.out.println(sb.toString());

    }


    public static void working(LinkedList<Integer> nodes, int task, int limit) {
        if (nodes.contains(task)) {
            nodes.remove(nodes.indexOf(task));
            nodes.addFirst(task);
        } else{
            nodes.removeLast();
            nodes.addFirst(task);
        }
    }
}
