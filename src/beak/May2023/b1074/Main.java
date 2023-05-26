package beak.May2023.b1074;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n;
    static int r;
    static int c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int p = (int)Math.pow(2, n);
        int max = (int)Math.pow(p,2);
        int index = findIndex(0, 0,p,p, 0, max / 4);
        System.out.println(index);
    }

    private static int findIndex(int minRow, int minCol,int maxRow,  int maxCol, int minV, int flag) {
        // 4분면 체크
        // 중간 점 찾기
        int midRow = (minRow + maxRow) /2;
        int midCol = (minCol + maxCol) / 2;
        int div = 1;
        if(r >= midRow)
            div +=2;
        if(c >= midCol)
            div++;

        if(flag == 1)
            return minV + div -1;

        // 아니면 나눠줘야 해
        if(div == 1)
            return findIndex(minRow, minCol, midRow, midCol, minV, flag/4);
        else if (div == 2)
            return findIndex(minRow,midCol, midRow, maxCol, minV + flag * (div-1), flag/4);
        else if(div == 3)
            return findIndex(midRow,minCol, maxRow, midCol, minV + flag * (div-1), flag/4);
        else
            return findIndex(midRow,midCol, maxRow, maxCol, minV + flag * (div-1), flag/4);
    }

}