import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


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
        Queue<Integer> pq = new PriorityQueue<>();

        while (startIndex < n) {
            currentTime = startSort[startIndex].startTime;
            while (startIndex < n && currentTime >= startSort[startIndex].startTime) {
                pq.add(startSort[startIndex].endTime);
                startIndex++;
            }
            while (!pq.isEmpty() && currentTime >= pq.peek()) {
                pq.poll();
            }
            maxRoom = Math.max(maxRoom, pq.size());
        }

        System.out.println(maxRoom);
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


}