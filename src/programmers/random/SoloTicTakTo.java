package programmers.random;

import java.io.IOException;

public class SoloTicTakTo {



    public int solution(String[] board) {
        int answer = -1;

        int nOfO = 0;
        int nOfX = 0;
        for(int i = 0; i<3; i++)
            for(int j = 0; j<3; j++){
                if(board[i].charAt(j)=='O')
                    nOfO++;
                else if(board[i].charAt(j)=='X')
                    nOfX++;
            }

        boolean oBing = false;
        boolean xBing = false;
        // 가로 빙고
        for(int i = 0; i<3; i++){
            char c = board[i].charAt(0);
            if(c == '.')
                continue;
            boolean flag = true;
            for(int j = 1; j<3; j++){
                flag = flag && (c == board[i].charAt(j));
            }
            if(flag){
                if(c == 'O')
                    oBing = true;
                else if(c == 'X')
                    xBing = true;
            }
        }
        // 세로 빙고
        for(int i = 0; i<3; i++){
            char c = board[0].charAt(i);
            if(c == '.')
                continue;
            boolean flag = true;
            for(int j = 1; j<3; j++){
                flag = flag && (c == board[j].charAt(i));
            }
            if(flag){
                if(c == 'O')
                    oBing = true;
                else if(c == 'X')
                    xBing = true;
            }
        }
        // 대각 빙고 \


        char c = board[0].charAt(0);
        if(c != '.'){

            boolean flag = true;
            for(int j = 1; j<3; j++){
                flag = flag && (c == board[j].charAt(j));
            }
            if(flag){
                if(c == 'O')
                    oBing = true;
                else if(c == 'X')
                    xBing = true;
            }
        }



        // 대각 빙고 /

        c = board[2].charAt(0);
        if(c != '.'){
            boolean flag = true;
            for(int j = 1; j<3; j++){
                flag = flag && (c == board[2-j].charAt(j));
            }
            if(flag){
                if(c == 'O')
                    oBing = true;
                else if(c == 'X')
                    xBing = true;
            }
        }




//         개수 규칙

        if(nOfX > nOfO)
            return 0;
        if(nOfO - nOfX > 1)
            return 0;
        if(oBing && xBing)
            return 0;
        if(xBing && nOfO - nOfX != 0)
            return 0;
        if(oBing && nOfO - nOfX != 1)
            return 0;



        return 1;
    }



    public static void main(String[] args) throws IOException {

        String [] a = {"OXX", "XOO", "OOX"};
        System.out.println(((new SoloTicTakTo().solution(a))));

    }
}
