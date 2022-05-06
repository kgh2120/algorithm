package Inflearn.StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Inflearn_5_7_studyPlanning {

    public static void answer(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Character> queue = new LinkedList<>();
        String sequence = sc.next();
        String fullPlan = sc.next();

        for (char c : sequence.toCharArray()) {
            queue.add(c);
        }

        for (char c : fullPlan.toCharArray()) {
            if (sequence.contains(c+"")) {

                if (queue.peek().equals(c)) {
                    queue.poll();
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        if (!queue.isEmpty()) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }


    /**
     * sequence.contains 에서 queue.contain 으로 수정함.
     * if-else 문을 if문 하나로 수정.
     */
    public static void solution(String[] args) {
            Scanner sc = new Scanner(System.in);

            Queue<Character> queue = new LinkedList<>();
            String sequence = sc.next();
            String fullPlan = sc.next();

            for (char c : sequence.toCharArray()) {
                queue.add(c);
            }
            for (char c : fullPlan.toCharArray()) {
                if (queue.contains(c)) {
                   if(queue.poll()!=c)
                        System.out.println("NO");
                        return;
                    }
                }

            if (!queue.isEmpty()) {
                System.out.println("NO");
                return;
            }
            System.out.println("YES");
        }



    }

