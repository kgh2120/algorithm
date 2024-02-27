import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {

        Map<String, Double> scoreMapper = new HashMap<>();
        scoreMapper.put("A+", 4.5);
        scoreMapper.put("A0", 4.0);
        scoreMapper.put("B+", 3.5);
        scoreMapper.put("B0", 3.0);
        scoreMapper.put("C+", 2.5);
        scoreMapper.put("C0", 2.0);
        scoreMapper.put("D+", 1.5);
        scoreMapper.put("D0", 1.0);
        scoreMapper.put("F", 0.0);

        double totalValue = 0.0;
        double totalTime = 0;
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            double time = Double.parseDouble(st.nextToken());
            String score = st.nextToken();

            if(score.equals("P"))
                continue;

            totalValue += time * scoreMapper.get(score);
            totalTime += time;
        }

        System.out.println(totalValue/totalTime);
    }


}