import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Character> queue = new LinkedList<>();
        String sequence = sc.next();
        String fullPlan = sc.next();

        for (char c : sequence.toCharArray()) {
            queue.add(c);
        }
        for (char c : fullPlan.toCharArray()) {
            if (queue.contains(c)) {
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



}