import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        Map<String,Integer> genresIndexMap = new HashMap<>();
        int listIndex = 0;
        List<PlayCounter> nodes = new ArrayList<>();
        Map<String, PriorityQueue<Node>> pqMap = new HashMap<>();
        
        for(int i = 0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            Integer genreIndex = genresIndexMap.get(genre);
            if(genreIndex == null){
                genreIndex = listIndex;
                genresIndexMap.put(genre, listIndex++);
                nodes.add(new PlayCounter(genre));
            }
            nodes.get(genreIndex).totalPlay += play;
            
            PriorityQueue pq = pqMap.get(genre);
            if(pq == null){
                pq = new PriorityQueue<Node>();
                pqMap.put(genre,pq);
            }
            pq.add(new Node( play , i));
            
        }
        
        Collections.sort(nodes);
        List<Integer> ans = new ArrayList<>();
        for(PlayCounter pc : nodes){
            PriorityQueue<Node> pq = pqMap.get(pc.genres);
            
            int c = 0;
            while(!pq.isEmpty() && c < 2){
                c++;
                ans.add(pq.poll().index);
            }
        }
        
        answer = new int[ans.size()];
        for(int i = 0; i<ans.size(); i++)
            answer[i]= ans.get(i);
        
        
        
        return answer;
    }
    
    static class PlayCounter implements Comparable<PlayCounter>{
        String genres;
        int totalPlay;
        
        public PlayCounter(String genre){
            genres = genre;
        }
        
        @Override
        public int compareTo(PlayCounter o){
            return Integer.compare(this.totalPlay, o.totalPlay) * -1;
        }
    }
    
    static class Node implements Comparable<Node>{
        int plays;
        int index;
        
        public Node(int p, int i){
            plays = p;
            index = i;
        }
        
        @Override
        public int compareTo(Node o){
            
            int v = Integer.compare(this.plays, o.plays) * -1;
            
            if(v == 0){
                return Integer.compare(this.index, o.index);
            }
            return v;
            
        }
    }
}