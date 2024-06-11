import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String text = br.readLine();
            boolean flag = true;

            for (int l = 0, r = text.length() - 1; l < text.length() && l != r; l++, r--) {
                char left = text.charAt(l);
                char right = text.charAt(r);

                if (left == right)
                    continue;
                // 대소문자 구분하기
                if (Character.isAlphabetic(left) && Character.isAlphabetic(right) && Character.toUpperCase(left) == Character.toUpperCase(right)) {
                    continue;
                }
                flag = false;
                break;
            }
            sb.append(flag ? "Yes\n" : "No\n");
        }
        System.out.println(sb);
    }


}