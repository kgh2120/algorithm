import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 20437 문자열 게임2
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Map<Character, List<Integer>> indexMap;

    static StringBuilder sb = new StringBuilder();
    static String words;
    static int k;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        // 하나씩 먹으면서 get()의 size가 K개 이상이 되면 그 사이를 체크한다.
        // add를 할 때엔 인덱스를 넣는다.
        // 그래서 그 사이를 체크한다.

        for (int i = 0; i < T; i++) {
            initMap();
            words = br.readLine();
            k = Integer.parseInt(br.readLine());

            char[] arr = words.toCharArray();
            int min = Integer.MAX_VALUE;
            int max = -1;
            for (int j = 0; j < arr.length; j++) {

                char c= arr[j];
                List<Integer> index = indexMap.get(c);
                index.add(j);
                int size = index.size();
                if (size >= k) {

                        min = Math.min(min, index.get(size-1) - index.get(size - k));

                    max = Math.max(max, index.get(size-1) - index.get(size - k));
                }
            }

            if (min == Integer.MAX_VALUE && max == -1) {
                sb.append(-1).append("\n");
            }else{
                sb.append(min+1).append(" ").append(max+1).append("\n");
            }
        }
        System.out.println(sb);

    }

    static void initMap(){
        char c = 'a';
        indexMap = new HashMap<>();
        while ((c <= 'z')) {
            indexMap.put(c++, new ArrayList<>());
        }
    }



}