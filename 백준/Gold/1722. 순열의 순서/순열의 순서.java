import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;

    static long[] factorial;
    static List<Integer> list;
    public static void main(String[] args) throws Exception{
        // 코드를 작성해주세요
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(input.readLine());
        factorial = new long[n+1];
        factorial[0] = 1L;
        factorial[1] = 1L;
        for(int i = 2; i<=n; i++){
            factorial[i] =  (factorial[i-1] * i);
        }

        list = new ArrayList<>();
        for(int i = 1; i <= n; i++)
            list.add(i);

        st = new StringTokenizer(input.readLine());
        int command = Integer.parseInt(st.nextToken());
        if(command == 1){
            long k = Long.parseLong(st.nextToken()) -1;
            int [] arr = new int[n+1];
            findOrder(k, 1, arr);

            for(int i =1; i<= n; i++)
                sb.append(arr[i]).append(" ");


        } else {
            // 주어진 숫자가 list의 몇번째 인덱스인지를 체크하고, 그 인덱스 * (n-1)!씩 하면서 더해주기.
            long order = 0;
            for(int i = 1; i <= n; i++){
                int v = Integer.parseInt(st.nextToken());
                int index = list.indexOf(v);
                list.remove(index);
                order += (factorial[n-i] * index);;
            }
            sb.append(order+1);
        }

        System.out.println(sb);


    }

    static void findOrder(long k, int floor, int[] array){
        if(floor == n){
            array[floor] = list.get(0);
            return;
        }

        // k가 어디에 속하는지 체크하기
        // k / (n-floor)!
        int bound = (int)(k / factorial[ n - floor ]);
        array[floor] = list.get(bound);
        list.remove(bound);
        long next = (k % factorial[ n - floor ]);
        findOrder(next , floor+1, array);
    }


}
