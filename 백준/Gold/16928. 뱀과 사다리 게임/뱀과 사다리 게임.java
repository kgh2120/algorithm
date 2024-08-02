import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


/*
    @제약사항 : 1초 512mb
    @입력 범위 :
    @문제 내용 :
        뱀과 사다리 게임을 한다. 10 x 10 보드판에서, 게임을 하는데, 주사위를 굴려서 이동한다.
        나는 1번 칸에서 시작하고, 주사위를 열심히 굴려서 100번칸으로 도달하면 된다.
        이 게임에서는 2가지 장치가 있다.
        사다리를 타면, 현재 위치보다 더 높은 위치로 이동할 수 있고, 뱀을 타면 현재 위치보다 더 뒤로 돌아가게 된다.
        아무튼 100번까지 최대한 짧게 사용해서 가라.

        ---

        일단 최단거리니까 BFS로 진행하고, 방문한 케이스에 대해서 visited 배열을 만들어서 체크해주면 될 것 같다.
        뱀과 사다리의 경우는 그냥 시작위치 -> 결과 위치로만 구분되기 때문에, 따로 구분할 필요는 없어보이고, MAP으로 쓰거나, int 배열을 만들어서 사용하면 될 듯 싶다.

        그리고 실제로 2차원 배열을 만들 필요는 없어보인다.
    @주의 사항 :
    @예상 알고리즘 : BFS
*/
public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[101];
        int[] item = new int[101];

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            item[from] = to;
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;

        int turn = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            turn++;
            while (size-- > 0) {
                Integer cur = q.poll();

                for (int i = 1; i <= 6 ; i++) {

                    int next = cur+i;


                    if (item[next] != 0) {
                        next = item[next];
                    }

                    if (next >= 100) {
                        System.out.println(turn);
                        return;
                    }

                    if(visited[next]) continue;
                    visited[next] = true;
                    q.add(next);
                }
            }
        }




    }
}