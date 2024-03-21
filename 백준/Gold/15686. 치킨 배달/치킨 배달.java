import java.io.*;
import java.util.*;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static House head;
    static List<BBQ> bbqs;
    static int min = Integer.MAX_VALUE;

    static int m;
    static int[] selected;
    public static void main(String[] args) throws Exception {

        setVariables();
        combination(0,0);
        System.out.println(min);


    }

    static void combination(int depth, int prev){

        if(depth == m){
            findMin();
            return;
        }

        for(int i = prev; i < bbqs.size(); i++){
            selected[depth] = i;
            combination(depth+1, i+1);
        }


    }

    static void findMin(){

        // 뺑이 돌면서 최단거리 찾기

        House temp = head;
        int total = 0;
        while(temp != null){
            int minDist = Integer.MAX_VALUE;
            for(int index : selected){
                BBQ bbq = bbqs.get(index);
                minDist = Math.min(minDist, calculateDistance(temp.row, temp.col , bbq.row, bbq.col));
            }
            total += minDist;
            temp = temp.next;
        }
        min = Math.min(min, total);
    }

    static int calculateDistance(int r1, int c1, int r2, int c2){
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);

    }

    static void setVariables() throws Exception{
        st = new StringTokenizer(br.readLine());
        bbqs = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        selected = new int[m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int value = Integer.parseInt(st.nextToken());
                if(value == 1){
                    head = new House(i,j,head);
                }else if(value == 2){
                    bbqs.add(new BBQ(i,j));
                }
            }
        }

    }

    static class BBQ{
        int row;
        int col;

        BBQ(int r, int c){
            row = r;
            col = c;
        }
    }


    static class House{
        int row;
        int col;
        House next;

        House(int row, int col, House n){
            this.row = row;
            this.col = col;
            next = n;
        }
    }

}