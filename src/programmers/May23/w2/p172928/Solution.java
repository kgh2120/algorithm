package programmers.May23.w2.p172928;

import java.util.StringTokenizer;

class Solution {
    int r;
    int c;
    int maxR;
    int maxC;
    String[] park;

    public int[] solution(String[] park, String[] routes) {

        this.park = park;

        r=0;
        c = 0;
        maxR = park.length;
        maxC = park[0].length();
        for(int i = 0; i<park.length;i++){
            c = park[i].indexOf("S");
            if(c != -1){
                r = i;
                break;
            }
        }

        StringTokenizer st;
        for(int i = 0; i<routes.length; i++){
            st = new StringTokenizer(routes[i]);
            String direction = st.nextToken();
            int w = Integer.parseInt(st.nextToken());

            move(direction,w);
        }
        int[] answer = {r,c};

        return answer;
    }
    public void move(String direction, int w){
        switch(direction){
            case "E" :
                if(c+w < maxC){
                    boolean canMove = true;
                    for(int i = c+1; i<= c+w; i++){
                        if(park[r].charAt(i)==('X')){
                            canMove = false;
                            break;
                        }
                    }
                    if(canMove){
                        c = c+w;
                    }
                }
                break;
            case "W" :
                if(c-w >= 0){
                    boolean canMove = true;
                    for(int i = c-1; i>= c-w; i--){
                        if(park[r].charAt(i)==('X')){
                            canMove = false;
                            break;
                        }
                    }
                    if(canMove){
                        c = c-w;
                    }
                }
                break;
            case "S" :
                if(r+w < maxR){
                    boolean canMove = true;
                    for(int i = r+1; i<= r+w; i++){
                        if(park[i].charAt(c)=='X'){
                            canMove = false;
                            break;
                        }
                    }
                    if(canMove){
                        r = r+w;
                    }
                }
                break;
            case "N" :
                if(r-w  >= 0){
                    boolean canMove = true;
                    for(int i = r-1; i>= r-w; i--){
                        if(park[i].charAt(c)=='X'){
                            canMove = false;
                            break;
                        }
                    }
                    if(canMove){
                        r = r-w;
                    }
                }
                break;
        }


    }
}