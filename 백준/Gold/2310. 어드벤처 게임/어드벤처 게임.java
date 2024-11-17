import java.io.*;
import java.util.*;

/*
240814
4:16
BJ2310 어드벤처 게임 - 골4
 */

public class Main {

    static int n;

    static class Room {
        char type;
        int money;

        Room(char type, int money) {
            this.type = type;
            this.money = money;
        }
    }

    static class Node {
        int curRoom;
        int leftMoney;

        Node(int curRoom, int leftMoney) {
            this.curRoom = curRoom;
            this.leftMoney = leftMoney;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            n = Integer.parseInt(in.readLine());
            if (n == 0) break;

            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i <= n; ++i) {
                adjList.add(new ArrayList<>());
            }

            Room[] rooms = new Room[n + 1];

            for (int i = 1; i <= n; ++i) {
                st = new StringTokenizer(in.readLine());

                String type = st.nextToken();
                if (type.equals("E")) {
                    rooms[i] = new Room('E', Integer.parseInt(st.nextToken()));
                } else if (type.equals("L")) {
                    rooms[i] = new Room('L', Integer.parseInt(st.nextToken()));
                } else if (type.equals("T")) {
                    rooms[i] = new Room('T', Integer.parseInt(st.nextToken()));
                }

                while (true) {
                    int to = Integer.parseInt(st.nextToken());
                    if (to == 0) break;
                    else adjList.get(i).add(to);
                }
            }

            // bfs
            boolean isPossible = false;

            boolean[] visited = new boolean[n + 1];
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(new Node(1, 0));

            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                int curRoom = cur.curRoom;
                int leftMoney = cur.leftMoney;

                // 현재 방 방문 가능 여부 확인
                boolean check = true;

                if (rooms[curRoom].type == 'E') {
                    // 지금 방에 방문 가능.
                } else if (rooms[curRoom].type == 'L') {
                    if (rooms[curRoom].money > leftMoney) {
                        leftMoney = rooms[curRoom].money;
                    }
                } else if (rooms[curRoom].type == 'T') {
                    if (rooms[curRoom].money > leftMoney) {
                        // 이 방으로 진입 불가. 여기서 끝
                        check = false;
                    } else {
                        leftMoney -= rooms[curRoom].money; // 통행료 지불
                    }
                }

                if (!check) continue; // 여기 방문 못 함...

                // 방문 가능 -> 방문 처리 후 다음 방 확인
                if (curRoom == n) { // n번 방까지 도착했다면...
                    isPossible = true;
                    break;
                }

                visited[curRoom] = true;
                for (int next : adjList.get(cur.curRoom)) {
                    if (!visited[next]) { // 아직 방문 안 한 곳이라면..
                        // 방문
                        queue.add(new Node(next, leftMoney));
                    }
                }
            }

            if (isPossible) {
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }
        }

        System.out.println(sb);

    }
}