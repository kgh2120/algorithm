import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Map<String, People> parentMap;
    static String root;

    static long rootRank;



    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        parentMap = new HashMap<>();
        root = br.readLine();

        rootRank = (long) Math.pow(2, n);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();

            String parentLeft  = st.nextToken();
            String parentRight = st.nextToken();

            parentMap.put(child, new People(parentLeft, parentRight, -1));
        }


        long maxRank = Long.MIN_VALUE;
        String ranker = null;
        for (int i = 0; i < m; i++) {

            String name = br.readLine();
            long rank = calculateRank(name);
            if(rank < 1)
                continue;

            

            if (maxRank < rank) {
                maxRank = rank;
                ranker = name;
            }

        }
        System.out.println(ranker);

        
    }

    static long calculateRank(String name){

        // 일단 이름이 있는지 체크
        // 이름이 없는데 root라면 1, root가 아니라면 0

        People people = parentMap.get(name);
        if(people == null){
            return root.equals(name) ? rootRank : 0;
        }

        // 이름이 있다면 재귀를 타면서 계산하기

        if(people.rank != -1)
            return people.rank;


        long sum = 0;
        sum += calculateRank(people.leftName);
        sum += calculateRank(people.rightName);

        people.rank = sum / 2;

        return people.rank;
    }


    static class People {
        String leftName;
        String rightName;
        long rank;

        // people이 없으면 rank가 0으로 취급하면 될듯.
        public People(String leftName, String rightName, long rank) {
            this.leftName = leftName;
            this.rightName = rightName;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "People{" +
                    "leftName='" + leftName + '\'' +
                    ", rightName='" + rightName + '\'' +
                    ", rank=" + rank +
                    '}';
        }
    }
}
