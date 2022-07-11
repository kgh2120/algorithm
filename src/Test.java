import Inflearn.forTest.FileChooseFrame;

import javax.swing.*;
import java.util.*;


public class Test {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[][] b = new int[5][3];
        b[0] = a;

        boolean equals = Arrays.equals(a, b[0]);
        System.out.println(equals);
    }

}
