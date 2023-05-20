package swea.May23.s16800;

import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            long target = sc.nextLong();
            long answer = 0;
            for(long i = (long)Math.sqrt(target); i >=1; i--){
                if(target % i ==0){
                    long pair = target / i;
                    answer = pair + i -2;
                    break;
                }
            }
            System.out.println("#" + test_case + " " + answer);

        }
    }
}
