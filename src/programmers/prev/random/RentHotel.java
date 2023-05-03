package programmers.prev.random;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    우선순위 큐와 정렬을 사용해서 문제를 풀었다.
    레벨 2
 */
public class RentHotel {

    public int solution(String[][] book_time) {
        int answer = 0;

        // 시간 비교 메서드
        Reservation[] r = new Reservation[book_time.length];
        int idx = 0;
        for(String[] book : book_time){
            r[idx++] = new Reservation(convertTime(book[0]), convertTime(book[1]) + 10);
        }

        Arrays.sort(r, new Comparator<Reservation>(){
            @Override
            public int compare(Reservation r1, Reservation r2){
                return r1.start - r2.start;
            }
        });

        PriorityQueue<Reservation> pq = new PriorityQueue<>(new Comparator<Reservation>(){
            @Override
            public int compare(Reservation r1, Reservation r2){
                return r1.end - r2.end;
            }
        });

        pq.add(r[0]);
        int cnt = 1;
        idx = 1;
        while(!pq.isEmpty() && idx != r.length){
            Reservation peek = pq.peek();

            if(peek.end > r[idx].start){
                pq.add(r[idx]);
                cnt++;
                idx++;
                continue;
            }
            pq.poll();
            pq.add(r[idx]);
            idx++;
        }



        return cnt;
    }

    private int convertTime(String time){
        StringTokenizer st = new StringTokenizer(time , ":");
        return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());

    }

    class Reservation{
        int start;
        int end;

        Reservation(int s, int e){
            start = s;
            end = e;
        }
    }



    public static void main(String[] args) throws IOException {

        String [][] a = {{"09:10", "10:10"}, {"10:20", "12:20"}};
        System.out.println(((new RentHotel().solution(a))));

    }
}
