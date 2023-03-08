package programmers.exhaustivesearch;

public class Fatigability {
    int answer = 0;

    public int solution(int k, int[][] dungeons) {
        bitmask(k,0,0,new boolean[dungeons.length], dungeons);
        return answer;
    }

    private void bitmask(int energy, int count, int depth, boolean[] visited, int[][] dungeons){
        if(depth == dungeons.length){
            answer = Math.max(count, answer);
            return;
        }

        for(int i = 0; i<dungeons.length; i++){
            if(!visited[i]){
                visited[i] = true;
                if(energy >= dungeons[i][0])
                    bitmask(energy - dungeons[i][1], count + 1, depth +1, visited, dungeons);
                bitmask(energy, count, depth +1, visited, dungeons);
                visited[i] = false;

            }
        }
    }




    public static void main(String[] args) {

        int a = 80;
       int [][] b = {{80,20},{50,40},{30,10}};


        System.out.println(((new Fatigability().solution(a,b))));
    }
}