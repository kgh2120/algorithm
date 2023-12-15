import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] arr;

    static List<Integer> answer;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        visited = new boolean[n+1];

        answer = new ArrayList<>();

        for (int i = 1; i <=n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n ; i++) {

            if(visited[i]) continue;
            makePair(i,i);
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");

        for (Integer integer : answer) {
            sb.append(integer).append("\n");
        }

        System.out.println(sb);

    }

    private static boolean makePair(int i, int index) {
        if (arr[index] == i) {
            visited[index] = true;
            answer.add(index);
            return true;
        }

        if(visited[index])
            return false;
        visited[index] = true;


        if (makePair(i, arr[index])) {
            answer.add(index);
            return true;
        }
        visited[index] = false;
        return false;
    }





}