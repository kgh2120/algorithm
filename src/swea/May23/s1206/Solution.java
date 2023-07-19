package swea.May23.s1206;

import java.util.Scanner;

class Solution
{

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=10;
        for(int test_case = 1; test_case <= T; test_case++)
        {

            int n = sc.nextInt();

            int answer = 0;

            int[] buildings = new int[n];
            for(int i = 0; i<n; i++)
                buildings[i] = sc.nextInt();

            for (int i = 2; i<n -2; i++){
                int max = Math.max(Math.max(buildings[i-2], buildings[i-1]),Math.max(buildings[i+2], buildings[i+1]));
                if(buildings[i] > max)
                    answer += buildings[i] - max;
            }
            System.out.println("#" + test_case +" " +answer);



        }
    }

}