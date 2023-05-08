package swea.May23.s15230;

import java.util.Scanner;


class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        char[] index = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            char[] input = sc.next().toCharArray();
            int count = 0;
            for(int i = 0; i < input.length;i++)
                if(input[i] == index[i]){
                    count++;
                }else
                    break;



            sb.append("#").append(test_case).append(" ")
                    .append(count).append("\n");

        }
        System.out.println(sb);
    }
}