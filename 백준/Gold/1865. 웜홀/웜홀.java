import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder answer = new StringBuilder();

    static int[][] adjMatrix;

    static final int FW_INITIAL_VALUE = 1_000_000_000;

    static final String SUCCESS = "YES";
    static final String FAIL = "NO";

    public static void main(String[] args) throws Exception {

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            init();
            String ans = isCycled() ? SUCCESS : FAIL;
            answer.append(ans).append("\n");

        }

        System.out.println(answer);







    }

    private static boolean isCycled() {

        int numberOfVertex = adjMatrix.length-1;

        for (int k = 1; k<=numberOfVertex; k++) {
            for (int i = 1; i <= numberOfVertex ; i++) {
                for (int j = 1; j <= numberOfVertex; j++) {
//                    if(i == j) continue;

                    if (adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
                        adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
                    }

                }

            }
        }

        for (int i = 1; i <= numberOfVertex ; i++) {
            if(adjMatrix[i][i] < 0)
                return true;
        }
        return false;

    }


    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        int numberOfVertex = Integer.parseInt(st.nextToken());
        int numberOfBridge = Integer.parseInt(st.nextToken());
        int numberOfHole = Integer.parseInt(st.nextToken());

        adjMatrix = new int[numberOfVertex+1][numberOfVertex+1];

        for(int i = 1; i <= numberOfVertex; i++){
            Arrays.fill(adjMatrix[i], FW_INITIAL_VALUE);
            adjMatrix[i][i] = 0;
        }
        inputEdges(numberOfBridge,true);
        inputEdges(numberOfHole,false);
    }

    static void inputEdges(int n, boolean isBridge) throws IOException {
        while(n-->0){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());


            if (isBridge) {
                adjMatrix[from][to] = Math.min(adjMatrix[from][to], value);
                adjMatrix[to][from] = Math.min(adjMatrix[to][from], value);
                continue;
            }
            adjMatrix[from][to] = Math.min(adjMatrix[from][to], value * -1);
        }
    }


}
