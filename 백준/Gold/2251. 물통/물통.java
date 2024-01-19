import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
    2251 물통
    물통에 담긴 물을 다른 물통으로 옮겨 담는다.
    물을 옮길 때의 규칙은 A -> B로 옮긴다고 했을 때, A의 양이 0이 되거나 B의 양이 최대로 되는 경우까지 물을 옮긴다.

    물통은 3개 A,B,C가 있고, 시작하면 A와 B는 물이 없고, C에만 물이 최대로 차있다.

    여러 경우가 존재할 때, A 물통에는 물이 없고, C에만 물이 있는 경우에서 C에 물이 얼마가 있는지 경우를 모두 나열하라는 문제이다.

    특별한 방법이 있는것 같지는 않고, BFS같이 돌면서 그 상황을 저장하면서 경우를 봐야겠다. 그런데 visited 체크를 해줘야 하는데
    이걸 딱히 생각이 안나니까 3차원 boolean 배열을 만들어서 A,B,C의 물 용량칸이 true면 visited로 생각해보자.
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int a;
    static int b;
    static int c;

    static boolean[][][] visited;
    static  int[] max;
    static Queue<int[]> q;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        max = new int[]{a, b, c};

        visited = new boolean[a+1][b+1][c+1];

        q = new ArrayDeque<>();
        int[] init = {0, 0, c};
        q.add(init);
        visited[0][0][c] = true;
        Set<Integer> set = new HashSet<>();

        while (!q.isEmpty()) {

            int[] poll = q.poll();
            if (poll[0] == 0) {
//                System.out.println(Arrays.toString(poll));
                set.add(poll[2]);
            }


            int calc = calc(poll, 0, 1);
            if (!visited[poll[0] - calc][poll[1] + calc][poll[2]]) {
                q.add(new int[]{poll[0] - calc, poll[1] + calc, poll[2]});
                visited[poll[0] - calc][poll[1] + calc][poll[2]] = true;
            }

            int calc2 = calc(poll, 0, 2);
            if (!visited[poll[0] - calc][poll[1]][poll[2] +  calc2]) {
                q.add(new int[]{poll[0] - calc2, poll[1], poll[2] +  calc2});
                visited[poll[0] - calc][poll[1]][poll[2] +  calc2] = true;
            }

            int calc3 = calc(poll, 1, 0);
            if (!visited[poll[0] + calc3][poll[1] - calc3][poll[2]]) {
                q.add(new int[]{poll[0] + calc3, poll[1]- calc3, poll[2]});
                visited[poll[0] + calc3][poll[1] - calc3][poll[2]] = true;
            }

            int calc4 = calc(poll, 1, 2);
            if (!visited[poll[0]][poll[1] - calc4][poll[2] + calc4]) {
                q.add(new int[]{poll[0], poll[1]- calc4, poll[2] + calc4});
                visited[poll[0]][poll[1] - calc4][poll[2] + calc4] = true;
            }

            int calc5 = calc(poll, 2, 0);
            if (!visited[poll[0] + calc5][poll[1]][poll[2] - calc5]) {
                q.add(new int[]{poll[0] + calc5,poll[1],poll[2] - calc5});
                visited[poll[0] + calc5][poll[1]][poll[2] - calc5] = true;
            }

            int calc6 = calc(poll, 2, 1);
            if (!visited[poll[0]][poll[1] + calc6][poll[2] - calc6]) {
                q.add(new int[]{poll[0],poll[1] + calc6,poll[2] - calc6});
                visited[poll[0]][poll[1] + calc6][poll[2] - calc6] = true;
            }
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);


    }
    static int calc(int[] poll, int from, int to){
        return Math.min(poll[from], max[to] - poll[to]);
    }

}