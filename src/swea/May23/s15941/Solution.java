package swea.May23.s15941;

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

            int k = sc.nextInt();
            sb.append("#").append(test_case)
                    .append(" ").append(k*k).append("\n");

        }
        System.out.println(sb);
    }
}