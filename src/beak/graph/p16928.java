package beak.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class p16928 {

    static int[] matrix;
    static Map<Integer, Integer> map;
    static Queue<Log> q;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ladder = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        for (int i = 0; i < ladder + snake; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        matrix = new int[101];
        bfs();
        // 내가 갈 수 있는 건 주사위 만큼 +1 +2 +3 +4 +5 +6

        System.out.println(matrix[100]);
    }

    public void bfs() {
        q = new LinkedList<>();
        q.add(new Log(1,0));
        while (!q.isEmpty()) {
            Log p = q.poll();
            roll(p);
        }

    }

    public void roll(Log p) {

        for (int i = 1; i <= 6; i++) {
            move(p,i);
        }


    }

    public void move(Log player, int num) {
        if (player.boardNum + num <= 100 && matrix[player.boardNum + num] == 0) {
            matrix[player.boardNum + num] = player.turn+1;
            if (map.containsKey(player.boardNum + num)) {
                matrix[map.get(player.boardNum + num)] = player.turn+1;
                q.add(new Log(map.get(player.boardNum + num), player.turn+1 ));
                return;
            }
            q.add(new Log(player.boardNum + num, player.turn+1));
        }
    }

    class Log{
        private int boardNum;
        private int turn;

        public Log(int boardNum, int turn) {
            this.boardNum = boardNum;
            this.turn = turn;
        }
    }


    public static void main(String[] args) throws Exception {
        new p16928().solution();
    }
}





