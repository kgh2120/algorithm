import com.sun.javafx.geom.Edge;

import java.util.*;
import java.io.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws Exception {

        int nOfRoom;
        while((nOfRoom = Integer.parseInt(br.readLine())) != 0){

            Room[] rooms = new Room[nOfRoom+1];
            int[] visited = new int[nOfRoom+1];
            Arrays.fill(visited,-1);
            for(int i = 1; i<=nOfRoom; i++){
                st = new StringTokenizer(br.readLine());
                String type = st.nextToken();
                int cost = Integer.parseInt(st.nextToken());

                rooms[i] = new Room(type, cost);
                while(st.hasMoreTokens()){
                    int toIndex = Integer.parseInt(st.nextToken());
                    if(toIndex == 0) break;
                    rooms[i].addTo(toIndex);
                }
            }
            Queue<Current> q = new ArrayDeque<>();
            q.add(new Current(1, 0));
            String ans = "No";
            // 만나면 해당 방부터 해결해라.
            while(!q.isEmpty()){
                Current cur = q.poll();

                Room curRoom = rooms[cur.index];

                // empty인지
                if (curRoom.type.equals("E")) {
                    if (cur.index == nOfRoom) {
                        ans = "Yes";
                        break;
                    } else {
                        // visited 처리해주기
                        for (int next : curRoom.to) {
                            if (visited[next] < cur.money) {
                                visited[next] = cur.money;
                                q.add(new Current(next, cur.money));
                            }
                        }
                    }
                }
                // L인지
                if (curRoom.type.equals("L")) {
                    if (cur.index == nOfRoom) {
                        ans = "Yes";
                        break;
                    } else {
                        for (int next : curRoom.to) {
                            int nextMoney = Math.max(cur.money, curRoom.value);
                            if (visited[next] < nextMoney) {
                                visited[next] = nextMoney;
                                q.add(new Current(next, nextMoney));
                            }
                        }
                    }
                }
                // T인지
                if (curRoom.type.equals("T") && cur.money >= curRoom.value) {
                    if (cur.index == nOfRoom) {
                        ans = "Yes";
                        break;
                    } else {
                        for (int next : curRoom.to) {
                            int nextMoney = cur.money - curRoom.value;
                            if (visited[next] < nextMoney) {
                                visited[next] = nextMoney;
                                q.add(new Current(next, nextMoney));
                            }
                        }
                    }
                }
            }
            answer.append(ans).append("\n");

        }

        System.out.println(answer);
    }

    static class Current{
        int index;
        int money;

        public Current(int index, int money) {
            this.index = index;
            this.money = money;
        }
    }

    static class Room{
        String type;
        int value;
        List<Integer> to;

        public Room(String type, int value){
            this.type = type;
            this.value = value;
            to = new ArrayList<>();
        }

        public void addTo(int index){
            to.add(index);
        }
    }

}
