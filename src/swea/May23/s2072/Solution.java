package swea.May23.s2072;

import java.util.Scanner;


class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int total = 0;
            for(int i = 0; i < 10; i++){
                int num = sc.nextInt();
                if(num % 2 == 1)
                    total += num;
            }
            sb.append("#").append(test_case).append(" ").append(total).append("\n");

        }
        System.out.println(sb);
    }
}