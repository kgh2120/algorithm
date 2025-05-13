import java.util.*;

/**

 장르의 노래가 많을 때,
 장르 내에서 많이 재생된 노래일 때, -> plays
 고유 번호가 낮을 때, -> index
 **/

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Genre> map = new HashMap<>();
        List<Genre> genreList = new ArrayList<>();

        for(int i = 0; i < genres.length; i++){

            String genre = genres[i];

            Genre g = map.get(genre);
            if(g == null){
                g = new Genre();
                genreList.add(g);
                map.put(genre, g);
            }
            g.count += plays[i];

            g.songQueue.add(new Song(i, plays[i]));

        }
        List<Integer> list = new ArrayList<>();
        Collections.sort(genreList);

        for (Genre g : genreList) {
            Collections.sort(g.songQueue);

            int end = Math.min(2, g.songQueue.size());

            for(int i = 0; i<end;i++)
                list.add(g.songQueue.get(i).index);
        }




    int[] answer = new int[list.size()];

        for(int i = 0; i<list.size(); i++)
            answer[i] = list.get(i);


        return answer;
}

static class Genre implements Comparable<Genre>{
    long count = 0L;
    // Queue<Song> songQueue = new PriorityQueue<>();
    List<Song> songQueue = new ArrayList<>();

    @Override
    public int compareTo(Genre o){

        return Long.compare(this.count, o.count) * -1;

    }

}

static class Song implements Comparable<Song>{
    Genre genre;
    int index;
    int plays;

    public Song(int i, int play){
        this.index = i;
        this.plays = play;
    }

    @Override
    public int compareTo(Song o){


        int comparePlay = Integer.compare(this.plays, o.plays) * -1;
        if(comparePlay == 0){
            return Integer.compare(this.index, o.index);
        }
        return comparePlay;


    }
}
}