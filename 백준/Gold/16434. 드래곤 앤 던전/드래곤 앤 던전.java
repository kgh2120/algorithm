import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws Exception {


        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long hAtk = Integer.parseInt(st.nextToken());

        long w = 0;
        long maxHp = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            int deal = Integer.parseInt(st.nextToken());
            int hp = Integer.parseInt(st.nextToken());
            if (type == 1) {
                long hitCount = hp / hAtk;
                if(hp % hAtk == 0) hitCount--;
                if(hitCount <= 0) continue;
                w += hitCount * deal;
            }else{
                hAtk += deal;
                maxHp = Math.max(maxHp, w+1);
                w = Math.max(0, w - hp);
            }
        }
        System.out.println(Math.max(maxHp, w+1));


    }



}