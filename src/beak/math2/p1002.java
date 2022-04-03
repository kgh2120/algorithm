package beak.math2;

import java.util.Scanner;

/*
    문제 : 터렛
    난이도 : 실버 4
    특징 : 두 원 사이의 교점에 관련된 내용을 물어보는 문제이다
        두 원사이에서 발생할 수 있는 경우는 총 6가지이다.
        자세한 내용은 아래 블로그를 참고.
        이 문제에서는 중요한 것은 오차가 발생하면 안된다는 것이다.
        처음에 double로 나타낼 값을 int형으로 강제 형변환 과정에서 오차가 발생해서
        그로 인해서 문제가 오답으로 된 케이스였다. 이를 생각하고 앞으로 문제를 풀어야 할 것이다.
        두 원 사이의 관계에 대한 내용
        https://mathbang.net/101
 */
public class p1002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loopCount = sc.nextInt();
        for(int i = 0; i<loopCount; i++)
            relationOfCircle(sc.nextInt(),sc.nextInt(),sc.nextInt(),
                    sc.nextInt(),sc.nextInt(),sc.nextInt());

    }

    private static void relationOfCircle(int x1, int y1, int r1, int x2, int y2, int r2){
        if(x1 == x2 && y1 == y2 && r1 == r2){

            System.out.println(-1);
            return;
        }
        int x = (x1-x2) * (x1-x2);
        int y = (y1-y2) * (y1-y2);

        double d =  Math.sqrt(x+y);

        int maxR = Math.max(r1, r2);
        int minR = Math.min(r1, r2);

        // case 1 두점
        if(r1+r2 > d && maxR - minR < d)
            System.out.println(2);
            // case 2 한점
        else if(r1+r2 == d || d + minR == maxR)
            System.out.println(1);
            // case 3 안만난다.
        else
            System.out.println(0);


    }
}
