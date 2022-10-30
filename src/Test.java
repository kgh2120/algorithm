import Inflearn.forTest.FileChooseFrame;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Test {


    public static void main(String[] args) throws IOException {
        Stack<Integer> s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        for (Integer o : s) {
            System.out.println(o);
        }
        System.out.println(s.size());
    }

}
