package beak.prev.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 예상 난이도 : 실버 5
 * 실제 난이도 : 실버 5
 * 특징 : 그 전에 풀었던 문제와 동일하지만, 조건만 달랐음.
 *        Comparator를 쓸 때, 조건을 1, 0 ,-1의 조건을 다시 봐야 할 거 같음.
 */

public class p11651 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int nOfDots = sc.nextInt();
        List<Coordinate> dots = new ArrayList<>();
        for (int i = 0; i < nOfDots; i++) {
            dots.add(new Coordinate(sc.nextInt(), sc.nextInt()));
        }

        dots.sort(new CoordinateComparator());

        for (int i = 0; i<nOfDots; i++)
            System.out.println(dots.get(i));

    }

    static class Coordinate{
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }

        public String toString() {
            return this.x + " " + this.y;
        }
    }

    static class CoordinateComparator implements Comparator<Coordinate> {
        // 1이 위임.
        @Override
        public int compare(Coordinate o1, Coordinate o2) {
            if (o1.getY() < o2.getY()) {
                return -1;
            }
            else if (o1.getY() == o2.getY()) {
                if(o1.getX()<o2.getX())
                    return -1;
                else
                    return 1;
            }else
                return 1;
        }
    }
}
