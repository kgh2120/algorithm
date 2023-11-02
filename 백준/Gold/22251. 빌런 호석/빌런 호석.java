import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
    W : 최대 층수
    K : 최대 자리수
    P : 총 바꿀 수 있는 LED 개수
    X : 현재 층

    K 에 따라서 X가 K 자리수로 주어지지 않아도 앞 자리수를 0으로 체크해줘야 할 수 있다.

    1. 각 숫자 0~9 가 다른 숫자가 되기 위해서 몇번의 움직임을 거치는지를 체크해준다.
    2. 맨 앞자리 ~ 맨 뒷자리까지 내가 이용할 수 있는 P를 쓰면서 조건을 체크할 수 있는지 본다. -> 완성한 수를 set에 저장하고 맨 마지막에 set의 size를 체크한다.
        2-1 현재 만든 수가 W보다 작지 않으면 그 수를 선택하지 않는다.


    만드는 방법.
        (1) Map<Integer, Map<Integer,List<Integer>>> 를 만들고, 0~9까지의 수를 key로, value에 있는 Map에는
        그 이전의 key인 수가 반전하는 수가 key, key번 반전해서 만들 수 있는 수가 value에 담긴다.


        (2) K 사이즈의 int 배열을 만든다.


        (3) 배열의 0번 혹은 K-1 인덱스부터 ++, -- 방향으로 P를 바꿔가면서 수를 조작해본다.
        (4) 이 과정에서 수가 W를 넘으면 그 반복은 피한다. 그러면 0번 인덱스부터 가는게 좋아보임.


 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int k;
    static int pp;
    static int x;
    static Set<Integer> answer;
    static int[][] nums = {{0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
    };

    public static void main(String[] args) throws Exception {
        setVariables();
        int [] arr = new int[k];
        String current = Integer.toString(x);

        int last =current.length()-1;
        int j = k-1;
        for (int i = last; i >= 0 ; i--) {
            arr[j--] = current.charAt(i) - '0';
        }
        // bf 코드 작성
        bf(0,arr, pp, n);
        System.out.println(answer.size());
    }

    private static void bf(int index, int[] arr, int p, int limit){
        if (index == k) {
            int number = parseInt(arr);
            if(number == 0 || number == x || number > limit) return;
            answer.add(number);
            return;
        }

        // arr[index]가 움직일 수 있는 만큼 움직이기.
        int currentNumber = arr[index];
        int[] costs = nums[currentNumber];
        for (int i = 0; i < costs.length; i++) {
            int cost = costs[i];
            if (p >= cost) {
                arr[index] = i;
//                if(parseInt(arr) <= limit)
                    bf(index+1, arr, p-cost, limit);
                arr[index] = currentNumber;
            }
        }
    }

    private static int parseInt(int [] arr){
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        return Integer.parseInt(sb.toString());
    }

    private static void setVariables() throws IOException {
        st = new StringTokenizer(br.readLine());
        answer = new HashSet<>();
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        pp = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
    }


}