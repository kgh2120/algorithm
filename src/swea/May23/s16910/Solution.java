package swea.May23.s16910;

import java.util.Scanner;

// D3 18min
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
            int total = 1;
            int prev = 1;
            int prevY = 1;
            for(int i = k-1; i >=0; i--){

                while(i*i + prevY*prevY <= k*k){
                    prevY++;
                    prev += 2;
                }
                if( i == 0){
                    total *=2;
                    total += prev;
                }else{
                    total += prev;
                }


            }
            sb.append("#").append(test_case)
                    .append(" ").append(total).append("\n");

        }
        System.out.println(sb);
    }
}