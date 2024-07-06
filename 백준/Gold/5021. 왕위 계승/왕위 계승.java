import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static String root;
    static Map<String, Parent> jokbo;
    static Map<String, Double> jokboDp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        root = br.readLine();

        jokbo = new HashMap<>();
        jokboDp = new HashMap<>();
        jokbo.put(root, null);
        jokboDp.put(root, 1.0);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jokbo.put(st.nextToken(), new Parent(st.nextToken(), st.nextToken()));
        }

        double min = -1 ;
        String answer = null;
        for (int i = 0; i < m; i++) {
            String hubo = br.readLine();
            double rank = find(hubo);
            if (rank > min) {
                min = rank;
                answer = hubo;
            }
        }
        System.out.println(answer);


    }

    private static double find(String name) {
        // 왼쪽 / 2 + 오른쪽 /2 할꺼야.
        // name에서 dp에 있다면 즉시 리턴해
        // !contains 면 0을 리턴해.
        // null을 가지고 있다면 1을 리턴해.

        if(jokboDp.containsKey(name))
            return jokboDp.get(name);
        if(!jokbo.containsKey(name))
            return 0;
        Parent parent = jokbo.get(name);
        if(parent == null)
            return 1;

        double rank = find(parent.left) / 2 + find(parent.right) / 2;
        jokboDp.put(name, rank);
        return rank;
    }

    static class Parent {
        String left;
        String right;

        public Parent(String left, String right) {
            this.left = left;
            this.right = right;
        }
    }

}