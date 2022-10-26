import java.util.Scanner;

public class Main {
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