import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String[] arr = new String[k];
            for (int j = 0; j < k; j++) {
                arr[j] = st.nextToken();
            }
            trie.put(0,arr);
        }

        trie.print(0);
        System.out.println(sb);
    }

    static class Trie{
        Map<String, Trie> data;

        public Trie(){
            data = new TreeMap<>();
        }
        public void put(int depth, String[] arr){
            if (depth == arr.length) {
                return;
            }
            if (!data.containsKey(arr[depth])) {
                data.put(arr[depth], new Trie());
            }
            data.get(arr[depth]).put(depth + 1, arr);
        }
        public void print(int depth){
            for (Map.Entry<String,Trie> e : data.entrySet()) {
                for (int i = 0; i < depth; i++) {
                    sb.append("--");
                }
                sb.append(e.getKey()).append("\n");
                e.getValue().print(depth+1);
            }
        }
    }
}