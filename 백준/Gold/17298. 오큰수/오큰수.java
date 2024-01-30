import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Arrays.fill(arr, -1);


        Node tail = null;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            while (tail != null && tail.value < number) {
                arr[tail.index] = number;
                tail = tail.prev;
            }
            tail = new Node(number, i, tail);
        }

        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);

    }

    static class Node {
        int value;
        int index;

        Node prev;

        public Node(int value, int index, Node prev) {
            this.value = value;
            this.index = index;
            this.prev = prev;
        }
    }


}