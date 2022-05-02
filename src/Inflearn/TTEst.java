package Inflearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TTEst {
    public static void main(String[] args) {

        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);



        Optional<Integer> reduce = l.stream().reduce((max, integer) -> {
            return integer > max ? integer : 0;
        });

        System.out.println(reduce.get());
    }

}
