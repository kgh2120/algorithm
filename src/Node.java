public class Node {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        int []a = {1,2,3,4};

        for (int i = 0; i < a.length; i++) {

            comb(a, Integer.toString(a[i]),i);
        }
        System.out.println(sb.toString());
    }

    public static void comb(int[]a, String s, int prev){

        if (prev == a.length) {
            System.out.println(s);
            return ;
        }

        for (int i = prev + 1; i <= a.length-1; i++) {
            comb(a,s + " " + a[i], i);
        }
    }
}
