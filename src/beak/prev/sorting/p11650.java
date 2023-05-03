package beak.prev.sorting;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 문제 : 좌표 정렬하기
 * 예상 난이도 : 실 3
 * 실제 난이도 : 실 5
 * 특징 : O(nlogn)을 활용해서 풀어야 하는 문제였다. Merge Sort, Heap Sort를 사용해서 풀면 되지만, 자바의 경우 Collection.sort기능을 활용해서
 *       풀라 하여, 그것으로 풀었음. 해법은 찾았으나, 정확한 조건을 쓰지 않아서 계속 틀렸던 문제. 앞으로는 필요 없는 조건이라고 생각하지 말고
 *       전부 기입해야 할 것이다.
 */
public class p11650 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int count = Integer.parseInt(br.readLine());
        ArrayList<Coordinate> cors = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Coordinate coordinate = new Coordinate(br.readLine());
            cors.add(coordinate);
        }

        cors.sort(new xComparator());

        for (Coordinate cor : cors) {
            bw.write(cor.toString()+"\n");
        }

        bw.flush();
    }

    public static class Coordinate {
        private int x;
        private int y;

        public Coordinate(String condition) {
            String[] c = condition.split(" ");
            x = Integer.parseInt(c[0]);
            y = Integer.parseInt(c[1]);
        }

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return x + " " + y;
        }
    }

    static class xComparator implements Comparator<Coordinate> {

        @Override
        public int compare(Coordinate o1, Coordinate o2) {
            if(o1.x < o2.x) return -1;
            else if(o1.x > o2.x) return 1;
            else{
                return Integer.compare(o1.y, o2.y);
            }
        }
    }

}
