import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 @author 김규현
 @since 2023-08-16
 @see
 @git
 @youtube
 @performance
 @category #
 @note

 dfs로 찍으면서 진행한다.
 끝에 도달하면 count를 +1해주고
 더이상 진행하지 못하는 시점에서 max랑 비교해서 값을 초기화 해준다.

 */
public class Main {
    static int R;
    static int C;
    static int[] dx = {-1, 0, 1};
    static char[][] graph;
    static boolean[][] visited;
    static boolean[][] failed;
    static boolean flag;
    static int result;

    public static void dfs(int nth, int[] choosed, boolean isStart, int startIdx) {

        if(nth == C) {
            result++;
            flag = true;
            return;
        }

        if(isStart) {
            choosed[nth] = startIdx;
            dfs(nth+1, choosed, false, startIdx);
            return;
        }
        else {
            for(int i = 0; i < 3; i++) {
                int nxt = choosed[nth-1] + dx[i];

                if(nxt < 0 || nxt >= R) {
                    continue;
                }
                if(graph[nxt][nth] == 'x' || visited[nxt][nth]) {
                    continue;
                }
                visited[nxt][nth] = true;
                choosed[nth] = nxt;
                dfs(nth+1, choosed, false, startIdx);
                if(flag) {
                    return;
                }
            }
            visited[choosed[nth-1]][nth] = true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        visited = new boolean[R][C];
        failed = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for(int j = 0; j < C; j++) {
                graph[i][j] = s.charAt(j);
            }
        }
        int ans = 0;
        for(int i = 0; i < R; i++) {
            flag = false;
            dfs(0, new int[C], true, i);
            if(flag) ans++;
        }
        System.out.println(ans);
    }

}