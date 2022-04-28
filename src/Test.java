import java.util.*;


public class Test {






    public static void main(String[] args) {
        Set<String> b = new HashSet<>();
        b.add("a");
        b.add("b");

        Set<String> a = new HashSet<>();
        a.add("a");


        boolean b1 = b.containsAll(a);
        boolean b2 = a.containsAll(b);
        System.out.println(b1 && b2);


    }


}
