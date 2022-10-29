import Inflearn.forTest.FileChooseFrame;

import javax.swing.*;
import java.util.*;


public class Test {


    public static void main(String[] args) {
        String a = "hello";
        StringTokenizer st = new StringTokenizer(a, "");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }

}
