import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static Map<Integer, List<Integer>> peopleToParty;
    static Map<Integer, List<Integer>> partyToPeople;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        peopleToParty = new HashMap<>();
        partyToPeople = new HashMap<>();
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            peopleToParty.put(i, new ArrayList<>());
        }
        for (int i = 1; i <= m; i++) {
            partyToPeople.put(i, new ArrayList<>());
        }
        st = new StringTokenizer(br.readLine());
        int nOfT = Integer.parseInt(st.nextToken());
        int[] tArray = new int[nOfT];
        for (int i = 0; i < nOfT; i++) {
            tArray[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int nOfPartyPeople = Integer.parseInt(st.nextToken());
            List<Integer> party = partyToPeople.get(i);
            for (int j = 0; j < nOfPartyPeople; j++) {
                int peopleNumber = Integer.parseInt(st.nextToken());
                party.add(peopleNumber);
                peopleToParty.get(peopleNumber).add(i);
            }
        }

        for (int i : tArray) {
            if(visited[i]) continue;
            bfs(i);
        }

        int answer = 0;

        loop: for (int i = 1; i <= m ; i++) {
            for (int p : partyToPeople.get(i)) {
                if(visited[p])
                    continue loop;
            }
            answer++;
        }
        System.out.println(answer);
    }

    static void bfs(int people) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(people);
        visited[people] = true;

        while (!q.isEmpty()) {
            Integer p = q.poll();
            for (int party : peopleToParty.get(p)) {
                for (int pp : partyToPeople.get(party)) {
                    if(visited[pp]){
                        continue;
                    }
                    visited[pp] = true;
                    q.add(pp);
                }
            }

        }

    }


}