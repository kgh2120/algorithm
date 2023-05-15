package programmers.May23.w2.p150370;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {


        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(today,".");
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        LocalDate t = LocalDate.of(y,m,d);


        Map<String,Integer> map = new HashMap<>();
        for(String s : terms){
            st = new StringTokenizer(s);
            map.put(st.nextToken(),Integer.parseInt(st.nextToken()));
        }


        for(int i = 0; i < privacies.length; i++){
            st = new StringTokenizer(privacies[i]);
            String date = st.nextToken();
            String condition = st.nextToken();
            st = new StringTokenizer(date,".");
            int year = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            LocalDate f = LocalDate.of(year,month,day);
            LocalDate after = f.plusMonths(map.get(condition));

            if(!t.isBefore(after))
                list.add(i+1);
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size();i++)
            answer[i] = list.get(i);

        return answer;
    }
}