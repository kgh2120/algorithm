import java.util.Arrays;

public class Node {


    public static void main(String[] args) {

        for(int i = 2; i < 100; i++){
            if(isPrimeNum(i))
                System.out.println(i + " : " + isPrimeNum(i));
        }

        System.out.println("========[에라토스테네스의 체]==========");
        boolean[] filter = eratosFilter(100);
        for(int i = 2; i<= 100; i++)
            if (!filter[i]) {
                System.out.println(i + " : " + filter[i]);
            }

    }

    private static boolean isPrimeNum(int num){
        if(num < 2)
            return false;
        for(int i = 2; i<= Math.sqrt(num); i++)
            if(num % i == 0)
                return false;
        return true;
    }

    private static boolean[] eratosFilter(int num){
        boolean[] e = new boolean[num + 1];

        for(int i =2 ; i<= Math.sqrt(num); i++){
            if(!e[i]){
                filter(e,i);
            }
        }
        return e;
    }

    private static void filter(boolean[] e, int i){
        int idx = 2;
        while(i*idx < e.length){
            e[i*idx] = true;
            idx++;
        }
    }
}
