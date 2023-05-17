package programmers.May23.w3.p92334;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

class Solution {
    /*
    한 턴에 한명 신고
    여러명을 신고할 수 있지만, 한 명한테는 한 번 밖에 못함.
    k번 신고당하면 정지당한다.
    내가 밴해서 정지당한 애는 메일을 받는다.
    그러면..
    Map으로 유저, Set<유저>를 한다.
    정지 먹은 애들을 찾는다. k번 넘은 친구들.
    */
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String,Set<Integer>> reported = new HashMap<>();
        for(String id : id_list)
            reported.put(id, new HashSet<>());
        Map<String,Integer> idMap = new HashMap<>();
        for(int i = 0; i< id_list.length; i++)
            idMap.put(id_list[i],i);



        StringTokenizer st;
        for(String rep : report){
            st = new StringTokenizer(rep);
            String from = st.nextToken();
            String to = st.nextToken();
            reported.get(to).add(idMap.get(from));
        }

        // 리포티드의 get의 사이즈가 k개 이상인 애들은, 신고한 애들을 꺼내서 배열에 ++해준다.
        for(Entry<String,Set<Integer>> entry : reported.entrySet()){
            if(entry.getValue().size() >= k){
                for(int index : entry.getValue()){
                    answer[index]++;
                }
            }
        }


        return answer;
    }
}