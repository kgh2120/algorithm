import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static boolean[] isBroken;
    static int target;
    static int min;
    static int length;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        length = s.length();
        target = Integer.parseInt(s);
        int nOfBroken = Integer.parseInt(br.readLine());
        isBroken = new boolean[10];

        if (nOfBroken != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens())
                isBroken[Integer.parseInt(st.nextToken())] = true;
        }




        min = Math.abs(target - 100);
        if (min == 0) {
            System.out.println(min);
            return;
        }
        findShortest(0,"");
        System.out.println(min);

    }

    private static void findShortest( int depth, String current){


        if(current.length() - length > 1)
            return;
        if(depth != 0){
            int count = Math.abs(Integer.parseInt(current) - target) + current.length();
            min = Math.min(min,count);
        }

        // 종료조건을 어떻게 잡아야 하지...
        // 자리수가 1개 차이나는 거 까지만 허용해야 할 듯.. 2개 넘어가면 멈추도록 해야 할 듯 하다.

        // 일단은 돌아가는 로직 부터

        for (int i = 0; i < 10; i++) {

            if(isBroken[i])
                continue;
            findShortest(depth+1, current+i);
        }

    }




}