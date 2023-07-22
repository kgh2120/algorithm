import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class P10773 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {


        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i = 0; i<n; i++){
            int target = Integer.parseInt(br.readLine());
            if(target != 0)
                stack.add(target);
            else{
                stack.pollLast();
            }
        }

        int total = 0;
        for (Integer integer : stack) {
            total += integer;
        }
        System.out.println(total);

    }



}