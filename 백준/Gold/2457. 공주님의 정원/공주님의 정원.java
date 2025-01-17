import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{



        int n = Integer.parseInt(input.readLine());
        Flower[] flowers = new Flower[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            flowers[i] = new Flower(sm,sd,em,ed);
        }

        Arrays.sort(flowers);

        // 시작지점 찾기

        Flower standard = new Flower(3,1,12,31);
        int curosr = 0;
        int count = 0;
        while (true) {




            int index = Arrays.binarySearch(flowers, standard);

            if (index < 0) {
                index = -index - 2;
            }

            Queue<Flower> pq = new PriorityQueue<>(new Comparator<Flower>() {
                @Override
                public int compare(Flower o1, Flower o2) {
                    return o1.end.isAfter(o2.end) ? -1 : 1;
                }
            });

            for (int i = curosr; i <= index; i++) {
                Flower flower = flowers[i];
                if(flower.end.isAfter(standard.start))
                    pq.add(flower);
            }

            if (pq.isEmpty()) {
                System.out.println(0);
                return;
            }

            Flower flower = pq.poll();
            standard = new Flower(flower.end.getMonthValue(), flower.end.getDayOfMonth(), 12,31);
            count++;
            curosr = index;


            if(flower.end.isAfter(LocalDate.of(2025,11,30)))
                break;
        }

        System.out.println(count);


    }

    static class Flower implements Comparable<Flower> {
        LocalDate start;
        LocalDate end;

        public Flower(int sm, int sd) {
            this.start = LocalDate.of(2025,sm,sd);
        }

        public Flower(int sm, int sd, int em, int ed) {
            start = LocalDate.of(2025, sm, sd);
            end = LocalDate.of(2025, em, ed);
        }

        @Override
        public int compareTo(Flower other) {
            int i = this.start.compareTo(other.start);
            if (i == 0) {
                return this.end.compareTo(other.end) ;
            }
            return i;
        }

        @Override
        public String toString() {
            return "Flower{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
