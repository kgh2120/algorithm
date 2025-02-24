import com.sun.javafx.geom.Edge;

import java.util.*;
import java.io.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws Exception {


        while(true){
            int nOfRoom = Integer.parseInt(br.readLine());
            if(nOfRoom == 0) break;
            Room[] rooms = new Room[nOfRoom+1];
//            int[] visited = new int[nOfRoom+1];
//            Arrays.fill(visited,-1);
            boolean[]visited = new boolean[nOfRoom+1];
            for(int i = 1; i<=nOfRoom; i++){
                st = new StringTokenizer(br.readLine());
                String type = st.nextToken();
                int cost = Integer.parseInt(st.nextToken());

                rooms[i] = new Room(type, cost);
                while(true){
                    int toIndex = Integer.parseInt(st.nextToken());
                    if(toIndex == 0) break;
                    rooms[i].addTo(toIndex);
                }
            }
            Queue<Current> q = new ArrayDeque<>();
            q.add(new Current(1, 0));
            String ans = "No";
//            visited[1] = true;
            // 만나면 해당 방부터 해결해라.
            while(!q.isEmpty()){
                Current cur = q.poll();

                Room curRoom = rooms[cur.index];

                int nextMoney = cur.money;
                if (curRoom.type.equals("L")) {
                    nextMoney = Math.max(cur.money, curRoom.value);
                }
                if (curRoom.type.equals("T") ) {
                    if(cur.money < curRoom.value)
                        continue;
                    else {
                        nextMoney = cur.money - curRoom.value;
                    }
                }
                if (cur.index == nOfRoom) {
                    ans = "Yes";
                    break;
                }
                visited[cur.index] = true;
                for (int next : curRoom.to) {
//                    if (visited[next] < nextMoney) {
//                        visited[next] = nextMoney;
//                        q.add(new Current(next, nextMoney));
//                    }
                    if (!visited[next]) {
                        q.add(new Current(next, nextMoney));
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
