import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {


    public void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack[] stacks = new Stack[4];
        for(int i = 0; i<4; i++)
            stacks[i] = new Stack<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[n];
        int idx = 0;

        while(st.hasMoreTokens())
            arr[idx++] = Integer.parseInt(st.nextToken());



        for (int i = 0; i < n; i++) {
            int target = arr[i];
            boolean flag = false;
            for(int j = 0; j<4; j++){
                if (stacks[j].isEmpty()) {
                    flag = push(stacks[j], target);
                    break;
                }
                Integer peek = (Integer) stacks[j].peek();
                if (target > peek) {
                    flag = push(stacks[j], target);
                    break;
                }
            }
            if (!flag) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private boolean push(Stack stacks, int target) {
        boolean flag = true;
        stacks.push(target);
        return flag;
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}
