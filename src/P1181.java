import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class P1181 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {


        int n = Integer.parseInt(br.readLine());
        Set<String> set = new LinkedHashSet<>();

        for(int i = 0; i<n; i++)
             set.add(br.readLine());

        ArrayList<String> list = new ArrayList<>(set);


        list.sort(new Comparator<String>(){
            public int compare(String left, String right){
                if(left.length() == right.length())
                    return left.compareTo(right);
                return left.length() - right.length();
            }
        });


        StringBuilder sb = new StringBuilder();

        String prev = "";
        for (String s : list) {
            if(prev.equals(s))
                continue;
            sb.append(s)
                    .append("\n");
            prev = s;
        }
        System.out.println(sb);



    }



}