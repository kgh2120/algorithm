package beak.prev.integer;

import java.util.Scanner;

/**
 *  끝자리에 0이 나오는 규칙을 생각해서 풀었던 문제.
 *  코드 자체는 좀더 깔끔하게 할 수 있을 거 같은데
 *  귀찮아서 그냥 했다.
 *  이전 팩토리얼에서는 2를 신경쓸 필요 없이 많아서 5만 신경썻는데
 *  조합 문제에서는 깎여 나가는 부분이 많아서 2도 신경써 주어야 했다.
 */

public class p2004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = sc.nextInt();
        int i2 = sc.nextInt();
        int f1 = fiveSquare(i);
        int f2 = fiveSquare(i2);
        int f3 = fiveSquare(i-i2);
        int t1 = twoSquare(i);
        int t2 = twoSquare(i2);
        int t3 = twoSquare(i-i2);


        int nOfF = f1 - (f2 + f3);
        int nOfT = t1 - (t2+t3);
        System.out.println(Math.min(nOfF,nOfT));

    }

    public static int fiveSquare(int k) {
        int r = 0;
        while (k!= 0) {
            k = k/5;
            r +=k;
        }
        return r;
    }
    public static int twoSquare(int k) {
        int r = 0;

        while (k != 0) {
            k = k/2;
            r +=k;
        }
        return r;
    }



}