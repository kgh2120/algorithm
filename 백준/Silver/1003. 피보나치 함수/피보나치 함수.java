import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * - @author 규현
 * - @since 2024-03-16
 * - @limit memory :  time :
 * - @performance
 * - @category
 * - @note
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());

        Node[] f = new Node[41];

        f[0] = new Node(1, 0);
        f[1] = new Node(0, 1);

        for (int i = 2; i <= 40 ; i++) {
            f[i] = new Node(f[i-1].countOfZero + f[i-2].countOfZero, f[i-1].countOfOne + f[i-2].countOfOne);
        }

        for (int i = 0; i < T; i++) {
            int index = Integer.parseInt(br.readLine());
            Node node = f[index];
            sb.append(node.countOfZero).append(" ").append(node.countOfOne).append("\n");
        }
        System.out.println(sb);
    }


    static class Node{
        int countOfZero;
        int countOfOne;

        public Node(int countOfZero, int countOfOne) {
            this.countOfZero = countOfZero;
            this.countOfOne = countOfOne;
        }
    }





}