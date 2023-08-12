import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.StringTokenizer;

/**

 @author 규현
 @since 2023-08-12
 @url
 @level
 @try
 @performance
 @category #
 @note

 더 큰 사람이 들어온다면, 저장된 스택에서 더 작은 애들을 꺼낸다.
 꺼낸 애 (pop)은 기존 스택을 순회하며, 자신보다 ㅏ더 큰 애가 나올 때까지 그 수를 카운팅하며
 자신이 만날 수 있는 최대 사람의 수를 센다ㅏ.
 그리고 새로 들어온 큰 친구는 무조건 만나니까 +1을 해준다. 이를 합한다.

 더 큰 사람이 들어오게 될 경우 작동하는 로직이기 때문에,
 반복문이 끝나도 스택에 값이 남아있을 수 있다.
 그래서 마지막에 한번 더 해준다.

 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Long> stack;
    static Deque<Integer> queue;
    static long result;



    public static void main(String[] args) throws Exception {

//        StringBuilder sb = new StringBuilder("500000\n");
//        for(int i = 0; i<500_000; i++)
//            sb.append(100).append(" ");
////        System.out.println(sb);
//
//        br = new BufferedReader(new StringReader(sb.toString()));

        int n = Integer.parseInt(br.readLine());

        stack = new ArrayDeque<>();
        queue = new ArrayDeque<>();
//        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long 키 = Long.parseLong(br.readLine());
//            int 키 = Integer.parseInt(st.nextToken());
            if(stack.isEmpty())
                stack.addFirst(키);
            else{
                // 신입의 키보다 막내가 작다면
                while (!stack.isEmpty() && stack.peekFirst() < 키) {
                    long cnt = 1;
                    Long pop = stack.pollFirst();

                    // 같은 애들 수를 센다 그리고 그 수가 더 큰ㅇ ㅐ를 만났다면  3n, 아니면 2n
                    while (!stack.isEmpty() && Objects.equals(stack.peekFirst(), pop)) {
                        cnt++;
                        stack.pollFirst();
                    }

                    if (cnt == 1) {
                        if(!stack.isEmpty())
                           cnt *=2;
                    }else{
                        if(stack.isEmpty())
                            cnt =  (cnt * (cnt-1))/2 + cnt;
                        else
                            cnt = (cnt * (cnt-1))/2 + cnt * 2;
                    }



                    result += cnt;

                }
                stack.addFirst(키);

            }

        }

//        System.out.println(stack);
        while (stack.size()>1) {
            Long 키 = stack.pollFirst();
            // 신입의 키보다 막내가 작다면
            long cnt = 1;
            while (!stack.isEmpty() && Objects.equals(stack.peekFirst(), 키)) {
                cnt++;
                stack.pollFirst();
                // 개들 다시 스택에 넣어준다.
            }
            if (cnt != 1) {
                if(!stack.isEmpty())
                    cnt = (cnt * (cnt - 1)) / 2 + cnt;
                else
                    cnt = (cnt * (cnt - 1)) / 2;
            }

            result += cnt;
        }


        System.out.println(result);


    }



}