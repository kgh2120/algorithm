package beak.Jul2023.p5397;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;


public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n,cursor;
    static List<Character> list;
    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());


        for(int i = 0; i<n; i++){
            list = new LinkedList<>();
            cursor = 0;
            String text = br.readLine();
            for(int j = 0; j<text.length(); j++){
                char c = text.charAt(j);
                switch (c){
                    case '<':
                        if(cursor > 0)
                            cursor--;
                        break;
                    case '>':
                        if(cursor < list.size())
                            cursor++;
                        break;
                    case '-':
                        if(cursor > 0)
                            list.remove(--cursor);
                        break;
                    default:
                        list.add(cursor++,c);
                        break;
                }
            }


            for (Character character : list) {
                sb.append(character);
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }





}