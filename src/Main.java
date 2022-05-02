import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nOfHero = sc.nextInt();
        int die = sc.nextInt();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nOfHero; i++) {
            queue.add(i+1);
        }

        while (queue.size() != 1) {
            int count = 1;
            while (count < die) {
                queue.add(queue.poll());
                count++;
            }
            queue.poll();
        }
        System.out.println(queue.poll());
    }



}