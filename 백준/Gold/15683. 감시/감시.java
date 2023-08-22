import java.util.*;
import java.io.*;




/*
    author : 규현
    date : 2023-08-22
    url : https://www.acmicpc.net/problem/15683
    performance :
    category : 
    note:

*/
class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n,m;
    static String[][] map;
    static boolean[][] vision;
    static int[] selectedDirection;
    static List<Camera> cameras;
    static int min;
    public static void main(String[] args) throws Exception {

        setVariables();
        dfs(0,vision);
        System.out.println(min);

    }

    private static void setVariables() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new String[n][m];
        vision = new boolean[n][m];
        cameras = new ArrayList<>();
        min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                String component = st.nextToken();
                map[i][j] = component;
                if (!component.equals("0")) {
                    vision[i][j] = true;
                    if (!component.equals("6")) {
                        cameras.add(new Camera(i,j,component));
                    }
                }
            }
        }
        selectedDirection = new int[cameras.size()];
    }


    private static void dfs(int depth, boolean[][] checked){
        if (depth == selectedDirection.length) {
            min = Math.min(min, getUnCheckedNumber(checked));
            return;
        }
        Camera camera = cameras.get(depth);
        if(camera.type.equals("5")){
            dfs(depth+1, action(camera, 0, copy(checked)));
        }else{
            dfs(depth+1, action(camera, 0, copy(checked)));
            dfs(depth+1, action(camera, 1, copy(checked)));
            dfs(depth+1, action(camera, 2, copy(checked)));
            dfs(depth+1, action(camera, 3, copy(checked)));
        }
    }

    private static int getUnCheckedNumber( boolean[][] checked) {
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if(!checked[i][j]) count++;
        return count;
    }

    private static boolean isIn(int row, int col) {
        return row>= 0 && row < n && col >= 0 && col <m;
    }

    private static boolean[][] action(Camera c, int direction, boolean[][] checked){
        switch (c.type) {
            case "1": checkVision(direction, c.row,c.col,checked);
                break;
            case "2":
                if (direction < 2) {
                    checkVision(0, c.row,c.col,checked);
                    checkVision(1, c.row,c.col,checked);
                }else{
                    checkVision(2, c.row,c.col,checked);
                    checkVision(3, c.row,c.col,checked);
                }
                break;
            case "3":
                if (direction == 0) {
                    checkVision(0, c.row,c.col,checked);
                    checkVision(3, c.row,c.col,checked);
                } else if (direction == 1) {
                    checkVision(1, c.row,c.col,checked);
                    checkVision(2, c.row,c.col,checked);
                } else if (direction == 2) {
                    checkVision(0, c.row,c.col,checked);
                    checkVision(2, c.row,c.col,checked);
                } else {
                    checkVision(1, c.row,c.col,checked);
                    checkVision(3, c.row,c.col,checked);
                }
                break;
            case "4":
                if (direction == 0) {
                    checkVision(0, c.row,c.col,checked);
                    checkVision(3, c.row,c.col,checked);
                    checkVision(2, c.row,c.col,checked);
                } else if (direction == 1) {
                    checkVision(1, c.row,c.col,checked);
                    checkVision(2, c.row,c.col,checked);
                    checkVision(3, c.row,c.col,checked);
                } else if (direction == 2) {
                    checkVision(0, c.row,c.col,checked);
                    checkVision(2, c.row,c.col,checked);
                    checkVision(1, c.row,c.col,checked);
                } else {
                    checkVision(1, c.row,c.col,checked);
                    checkVision(3, c.row,c.col,checked);
                    checkVision(0, c.row,c.col,checked);
                }
                break;
            case "5":
                checkVision(0, c.row,c.col,checked);
                checkVision(1, c.row,c.col,checked);
                checkVision(2, c.row,c.col,checked);
                checkVision(3, c.row,c.col,checked);
                break;
        }
        return checked;
    }

    // direction 0123 상하좌우
    private static void checkVision(int direction, int row, int col, boolean[][] checked ){
        int delRow = 0;
        int delCol = 0;
        switch (direction) {
            case 0 :
                delRow = -1;
                break;
            case 1 :
                delRow  = 1;
                break;
            case 2 :
                delCol = -1;
                break;
            case 3 :
                delCol = 1;
                break;
        }
        int nr = row + delRow;
        int nc = col + delCol;

        while (isIn(nr, nc) && !map[nr][nc].equals("6")) {
            checked[nr][nc] = true;
            nr += delRow;
            nc += delCol;
        }

    }

    private static boolean[][] copy(boolean[][] origin){
        boolean[][] copied = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(origin[i],0,copied[i],0,m);
        }
        return copied;
    }

    static class Camera{
        int row;
        int col;
        String type;

        public Camera(int row, int col, String type) {
            this.row = row;
            this.col = col;
            this.type = type;
        }
    }


}