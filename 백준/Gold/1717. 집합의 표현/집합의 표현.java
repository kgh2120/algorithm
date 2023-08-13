import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;


/**

@author 규현
@since 2023-08-13
@url
@level
@try
@performance
@category #
@note
 0~n 원소로 가지고 있는 n+1개의 집합이 있다.
 이 집합에 m개의 연산이 들어간다.
 연산의 종류로는 합집합 연산인  0 a b 와
 같은 집합 체크 연산인 1 a b 가 있다.

 1 a b 연산이 주어질 때 a와 b가 같은 집합에 포함되어 있는지를 체크하는 문제이다.

 0 ~ n 집합의 부모를 관리하는 배열을 만들고,
 합집합 연산이 주어진다면 둘의 부모 중 하나를 부모로 만들어 주면 될 듯 싶다.
 전형적인 Union - find 문제인듯 싶다.

 시간은 2초이고 n은 1_000_000
*/
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    static int[] parents;

    static Set<Operation> union;


    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        union = new HashSet<>();

        parents = new int[n+1];
        for(int i = 0; i<=n; i++)
            parents[i] = i;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Operation ops = new Operation(a, b);
            if (command == 0) {
                if (!union.contains(ops)) {
                    union(a, b);
                    union.add(ops);
                }
            }else{

                String ans;
                    if (a == b) {
                        ans = "YES";
                    }else
                        ans = findParents(a) == findParents(b) ? "YES" : "NO";


                sb.append(ans)
                        .append("\n");
            }
        }


        System.out.println(sb);


    }

    private static void union(int a, int b){
        if(a == b)
            return;

        int parentsOfA = findParents(a);
        int parentsOfB = findParents(b);

        if (parentsOfA == parentsOfB) {
            return;
        }
        else if (parentsOfA < parentsOfB) {
            parents[parentsOfB] = parentsOfA;
        }else {
            parents[parentsOfA] = parentsOfB;
        }

    }


    private static int findParents(int a) {
        if(parents[a] == a)
            return a;
        return findParents(parents[a]);
    }
    static class Operation{
        int a;
        int b;

        public Operation(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Operation operation = (Operation) o;
            return a == operation.a && b == operation.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }



}