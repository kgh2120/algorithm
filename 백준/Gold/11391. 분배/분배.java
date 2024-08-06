import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/*
    @제약사항 :
    @입력 범위 :
    @문제 내용 :
    @주의 사항 :
    @예상 알고리즘 :
*/
public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static boolean [] visited;
    static Map<Integer, Set<Integer>> bit;
    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        visited = new boolean[(int)Math.pow(2,n)];


        bit = new HashMap<>();

        for (int i = 0; i <= n; i++) {
            bit.put(i, new HashSet<>());
        }

        int totalBit = 0;
        for (int i = 0; i < Math.pow(2,n) ; i++) {
            int nOfBit = Integer.bitCount(i);
            totalBit += nOfBit;
            bit.get(nOfBit).add(i);
        }
        int t = (int) Math.pow(2, n-k);
        int remainNumber = (int) Math.pow(2,k);
        int remainBit = totalBit / remainNumber;

        for (int i = 0; i < remainNumber; i++) {

            divide(t, remainBit);
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static void divide(int remainNumberCount, int remainBitCount){
        if(remainNumberCount == 0) return;

        int targetBitCount = remainBitCount / remainNumberCount;
        int temp = targetBitCount;

        Set<Integer> integers = bit.get(targetBitCount);
        while (integers.isEmpty()) {
            integers = bit.get(temp);
            if(!integers.isEmpty()) break;
            if(temp <= targetBitCount)
                temp--;
            else if(temp > targetBitCount)
                temp++;
            if(temp < 0)
                temp = targetBitCount+1;
        }
        Integer t = null;
        for (Integer integer : integers) {
            if(visited[integer]) continue;
            t = integer;
            break;
        }
        visited[t] = true;

        integers.remove(t);

        sb.append(t).append(" ");
        targetBitCount = temp;
        divide(remainNumberCount-1, remainBitCount- targetBitCount);

    }

}