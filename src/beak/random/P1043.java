package beak.random;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

class P1043 {
    Map<Integer, List<Integer>> map;
    boolean []tPeople;
    boolean []pp;

    public void solution() throws Exception{
        int a = 150_000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nOfPeople = Integer.parseInt(st.nextToken());
        int nOfParty = Integer.parseInt(st.nextToken());
        int answer = 0;
        map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int nOfTruePerson = Integer.parseInt(st.nextToken());
        tPeople = new boolean[nOfPeople+1];
        for (int i = 1; i <= nOfPeople; i++) {
            map.put(i,new ArrayList<>());
        }
        for (int i = 0; i < nOfTruePerson; i++) {
            tPeople[Integer.parseInt(st.nextToken())] = true;
        }



        for (int i = 1; i <= nOfParty; i++) {
            st = new StringTokenizer(br.readLine());
            int nOfPeopleWhoComeParty =Integer.parseInt(st.nextToken());
            int[] people = new int[nOfPeopleWhoComeParty];
            boolean flag = false;
            for(int j = 0; j< nOfPeopleWhoComeParty; j++){
                people[j] = Integer.parseInt(st.nextToken());
                if(flag)
                    continue;
                if(tPeople[people[j]])
                    flag = true;
            }

            for (int person : people) {
                List<Integer> list = map.get(person);
                list.add(i);
                if(flag)
                    tPeople[person] = true;
            }

        }
        map.get(123);

        pp = new boolean[nOfParty+1];

        //
        for (int i = 1; i <= nOfPeople; i++) {
            if(tPeople[i]){
                List<Integer> list = map.get(i);
                for (Integer integer : list) {
                    pp[integer] = true;
                    for (Entry<Integer, List<Integer>> e : map.entrySet()) {
                        if(e.getValue().contains(integer)){
                            a(e.getKey());
                        }
                    }
                }
            }
        }



        for (int i = 1; i <= nOfParty ; i++) {
            if(!pp[i])
                answer++;
        }


        System.out.println(answer);

    }

    public void a(Integer key){

        if(tPeople[key])
            return;

        tPeople[key] = true;

        List<Integer> integers = map.get(key);


        for (Integer integer : map.keySet()) {
            List<Integer> list = map.get(integer);
            for (Integer integer1 : integers) {
                if(list.contains(integer1)){
                    a(integer);
                    pp[integer1] = true;
                }
            }
        }


    }


    public static void main(String[] args) throws Exception{
        new P1043().solution();
    }
}