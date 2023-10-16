

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static Lecture[] startSort;
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        startSort = new Lecture[n];
        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            Lecture lecture = new Lecture(index,startTime,endTime);
            startSort[i] = lecture;

        }

        Arrays.sort(startSort, new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                return Integer.compare(o1.startTime, o2.startTime);
            }
        });
        int startIndex = 0;
        int currentTime = 0;
        int maxRoom = 0;
        Queue<End> pq = new PriorityQueue<>();
        Queue<Integer> roomNumbers = new ArrayDeque<>();
        roomNumbers.add(1);
        int currentRoom = 0;
        int lastRoomNumber = 1;

        int[] result = new int[n+1];
        while (startIndex < n) {
            currentTime = startSort[startIndex].startTime;


            while (!pq.isEmpty() && currentTime >= pq.peek().endTime) {
                End poll = pq.poll();
                roomNumbers.add(poll.roomNumber);
                result[poll.index] = poll.roomNumber;;
            }



            while (startIndex < n && currentTime >= startSort[startIndex].startTime) {
                currentRoom++;

                if (roomNumbers.isEmpty()) {
                    roomNumbers.add(++lastRoomNumber);
                }
                pq.add(new End(startSort[startIndex].endTime, startSort[startIndex].index, roomNumbers.poll()));
                startIndex++;
            }

            maxRoom = Math.max(maxRoom, pq.size());
        }

        while (!pq.isEmpty()) {
            End poll = pq.poll();
            result[poll.index] = poll.roomNumber;;
        }

        sb.append(maxRoom).append("\n");
        for (int i = 1; i <= n ; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.print(sb);
    }

    static class Lecture {
        int index;
        int startTime;
        int endTime;

        public Lecture(int index, int startTime, int endTime) {
            this.index = index;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    static class End implements Comparable<End>{
        int endTime;
        int index;
        int roomNumber;

        public End(int endTime, int index, int roomNumber) {
            this.endTime = endTime;
            this.index = index;
            this.roomNumber = roomNumber;
        }

        @Override
        public int compareTo(End o) {
            return Integer.compare(endTime, o.endTime);
        }
    }

}