package beak.prev.math2;

import java.io.*;
import java.util.ArrayList;

/*
    문제 : 소인수분해
    난이도 : 실버 5
 */

public class p11653 {
    static ArrayList<String> arr = new ArrayList<>();
    static ArrayList<Integer> array = new ArrayList<>();
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        try {
            int target = Integer.parseInt(br.readLine());
            if(isPrimeNumber(target))
                arr.add(target+"");
            else
                find(target);
            for(String k : arr)
                array.add(Integer.parseInt(k));
            sort();

            for(int k : array)
                bw.write(Integer.toString(k)+"\n");
            bw.flush();
            bw.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    public static void find(int number){
        if(number == 1)
            return ;

        for(int i = (int) Math.sqrt(number); i>= 2; i--)
            if(number%i == 0){

                arr.remove(number + "");
                int a = i;
                int b = number/i;
                arr.add(a+"");
                find(a);
                arr.add(b+"");
                find(b);
                return ;
            }
    }

    public static void sort(){
        for(int i = 0; i<array.size()-1;i++)
            for(int j = i+1; j<array.size();j++)
                if(array.get(i) > array.get(j))
                    swap(i, j);
    }

    public static void swap(int i, int j){
        int temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }

    public static boolean isPrimeNumber(int number){
        if(number == 1)
            return false;
        for(int i = number-1; i>= Math.sqrt(number); i--)
            if(number%i == 0)
                return false;

        return true;
    }
}
