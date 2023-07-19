import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {
    static int n, m;
    static int[][] map;
    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static ArrayList<int[]> choice = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        String a = "***\n***\n***";
        String b = "***\n***\n***";
        sb.append(a).append(b);
        System.out.println(sb);

    }

    static void back(int depth, int start) {
        if (depth == m) {
            int sum = 0;
            for (int[] h : house) {
                int min = Integer.MAX_VALUE;
                for (int[] c : choice) {
                    int d = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    min = Math.min(d, min);
                }
                sum += min;
            }
            result = Math.min(result, sum);
            return;

        }


        for (int i = start; i < chicken.size(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                choice.add(chicken.get(i));
                back(depth + 1, i + 1);
                // 시간초과는 start를 매개변수로 사용해서 가지치기 수
                // 백트래킹에서 시간초과는 가지치기를 수행해 해결한다
                choice.remove(choice.size() - 1);// 추가
//                choice.remove(chicken.get(i));// 이것도 가능
                // 원래 배열을 사용했는데 배열은 위에 덮어써서 삭제 부분이 필요없었는데
                // 이것은 리스트라 삭제가 안되고 계속 삽입되므로 제거하는 로직을 추가해야한다.
                visit[i] = false;
            }
        }
    }
}