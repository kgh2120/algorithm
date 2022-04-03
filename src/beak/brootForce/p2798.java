package beak.brootForce;

import java.io.*;
import java.util.ArrayList;


public class p2798 {
    static int max =0;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String[] conditions = br.readLine().split(" ");
            int nOfCard = Integer.parseInt(conditions[0]);
            int targetNum = Integer.parseInt(conditions[1]);

            String[] cards = br.readLine().split(" ");

            for (int i = 0; i < nOfCard; i++) {
                list.add(Integer.parseInt(cards[i]));
            }
            blackJack(list, 0, targetNum, nOfCard-3);
            bw.write(Integer.toString(max));
            bw.flush();
            bw.close();
            br.close();


        } catch (IOException e) {
            e.printStackTrace();
        }





    }

    public static void blackJack(ArrayList<Integer> lists, int total, int target, int count){
        if(total > target) return;
        if(lists.size() == count){
            if(total > max)
                max = total;
            return;
        }

        for(int i = 0; i<lists.size();i++){
            int now = lists.get(i);
            lists.remove(i);
            total += now;
            blackJack(lists, total, target, count);
            lists.add(i, now);
            total -= now;
        }
    }
}