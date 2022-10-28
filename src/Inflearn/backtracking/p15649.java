package Inflearn.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  백트레킹 예제 문제 1.
 *  그냥 사전 순서대로 전부 탐색하기.
 */
public class p15649 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<Integer> commandSet = new HashSet<>();

        DFS(n, 0, m, commandSet, new ArrayList<Integer>());
        System.out.println(sb.toString());

    }

    public static void DFS(int n, int level, int end, Set<Integer> commands, List<Integer> results) {
        if (level == end) {
            for (int i = 0; i < results.size(); i++) {
                sb.append(results.get(i)+1).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (commands.contains(i))
                continue;
            commands.add(i);
            results.add(i);
            DFS(n, level + 1, end, commands, results);
            commands.remove(i);
            results.remove(results.indexOf(i));
        }


    }


}