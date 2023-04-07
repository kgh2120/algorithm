package programmers.random;

import java.util.HashMap;
import java.util.Map;

class RunningRace {
    Map<String,Integer> ranks;
    String[] players;
    String[] callings;
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        ranks = new HashMap<>();
        this.players = players;
        this.callings = callings;

        for(int i = 0; i<players.length; i++)
            ranks.put(players[i],i);

        for(String call : callings)
            swap(call);

        return players;
    }
    private void swap(String name){
        int l = ranks.get(name);
        int r = l-1;

        String temp = players[r];
        players[r] = name;
        players[l] = temp;
        ranks.put(name, r);
        ranks.put(temp,l);
    }



//    public static void main(String[] args) {
//
//
//        System.out.println(new Solution().solution(new int[]{2, 3, 3, 5}));
//    }
}