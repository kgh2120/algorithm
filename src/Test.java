import Inflearn.forTest.FileChooseFrame;

import javax.swing.*;
import java.util.*;


public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MessageUtil.printMenu("menu","보험상품조회","보험사고접수","보상담당자변경","시벌이건그냥예시야");
        
//        String a = sc.next();
//        switch (a) {
//            case "1" :
//                FileChooseFrame f = new FileChooseFrame();
//
//        }


    }
    static class MessageUtil{
        private static final StringBuilder sb = new StringBuilder();

        public static void printMenu(String header, String... conditions) {
            int max = maxLength(conditions);
                sb.append(header).append("\n");
            for (int i = 0; i < conditions.length; i++) {
                int nOfBlank = max - conditions[i].length();
                sb.append('*').append((i+1)+".").append(conditions[i]);
                createBlank(nOfBlank);
            }

            System.out.println(sb.toString());
        }

        private static void createBlank(int nOfBlank) {
            if (nOfBlank == 0) {
                sb.append(' ');
            }

            for (int i = 0; i < nOfBlank; i++) {
                sb.append("  ");
            }
            sb.append('*').append("\n");
        }

        private static int maxLength(String[] cons) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < cons.length; i++) {
                max = Math.max(max,cons[i].length());
            }
            return max;
        }

    }

}
