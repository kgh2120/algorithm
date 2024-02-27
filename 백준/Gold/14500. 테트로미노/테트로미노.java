import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int r;
    static int c;
    public static void main(String[] args) throws IOException {

        int max = -1;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1 ㅁ ㄱ z T

        //1

        List<Tetromino> t = Arrays.asList(new Straight(), new Square(), new T(), new L(), new Z());

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (Tetromino tetromino : t) {
                    List<Coord[]> deltas = tetromino.getDeltas();

                    loop: for (Coord[] delta : deltas) {
                        boolean flag = true;
                        int total = 0;
                        for (Coord coord : delta) {
                            int nr = i + coord.row;
                            int nc = j + coord.col;
                            if (!isIn(nr, nc)) {
                                continue loop;
                            }
                            total += matrix[nr][nc];
                        }
                        max = Math.max(max, total);
                    }
                }
            }
        }

        System.out.println(max);

    }
    static boolean isIn(int row, int col) {
        return row >= 0 && row < r && col >= 0 && col < c;
    }


     interface Tetromino{
        List<Coord[]> getDeltas();
    }
    static class Straight implements Tetromino{
        List<Coord[]> deltas;

        public Straight() {
            this.deltas = Arrays.asList(
                    new Coord[]{
                            new Coord(0,0),
                            new Coord(1,0),
                            new Coord(2,0),
                            new Coord(3,0)
                    },
                    new Coord[]{
                            new Coord(0,0),
                            new Coord(0,1),
                            new Coord(0,2),
                            new Coord(0,3)
                    }
            );
        }

        @Override
        public List<Coord[]> getDeltas() {
            return deltas;
        }
    }

    static class Square implements Tetromino{

        List<Coord[]> deltas;

        public Square() {
            Coord[] coords = {
                    new Coord(0, 0),
                    new Coord(0, 1),
                    new Coord(1, 0),
                    new Coord(1, 1)
            };
            deltas = new ArrayList<>();
            deltas.add(coords);
        }

        @Override
        public List<Coord[]> getDeltas() {
            return deltas;
        }
    }

    static class L implements Tetromino {
        List<Coord[]> deltas;

        public L() {

            deltas = new ArrayList<>();
            deltas.add(new Coord[]{
                    new Coord(0, 0),
                    new Coord(1, 0),
                    new Coord(2, 0),
                    new Coord(2, 1)
            });
            deltas.add(new Coord[]{
                    new Coord(0, 0),
                    new Coord(0, 1),
                    new Coord(0, 2),
                    new Coord(1, 0)
            });
            deltas.add(new Coord[]{
                    new Coord(0, 0),
                    new Coord(0, 1),
                    new Coord(1, 1),
                    new Coord(2, 1)
            });
            deltas.add(new Coord[]{
                    new Coord(0, 2),
                    new Coord(1, 0),
                    new Coord(1, 1),
                    new Coord(1, 2)
            });

            deltas.add(new Coord[]{
                    new Coord(0, 1),
                    new Coord(1, 1),
                    new Coord(2, 1),
                    new Coord(2, 0)
            });
            deltas.add(new Coord[]{
                    new Coord(0, 0),
                    new Coord(1, 1),
                    new Coord(1, 2),
                    new Coord(1, 0)
            });
            deltas.add(new Coord[]{
                    new Coord(0, 0),
                    new Coord(0, 1),
                    new Coord(1, 0),
                    new Coord(2, 0)
            });
            deltas.add(new Coord[]{
                    new Coord(0, 0),
                    new Coord(0, 1),
                    new Coord(0, 2),
                    new Coord(1, 2)
            });
        }

        @Override
        public List<Coord[]> getDeltas() {
            return deltas;
        }

    }

    static class T implements Tetromino {
        List<Coord[]> deltas;

        public T() {

            deltas = new ArrayList<>();
            deltas.add(new Coord[]{
                    new Coord(0, 1),
                    new Coord(1, 0),
                    new Coord(1, 1),
                    new Coord(1, 2)
            });
            deltas.add(new Coord[]{
                    new Coord(0, 0),
                    new Coord(1, 0),
                    new Coord(1, 1),
                    new Coord(2, 0)
            });
            deltas.add(new Coord[]{
                    new Coord(0, 0),
                    new Coord(0, 1),
                    new Coord(1, 1),
                    new Coord(0, 2)
            });
            deltas.add(new Coord[]{
                    new Coord(0, 1),
                    new Coord(1, 0),
                    new Coord(1, 1),
                    new Coord(2, 1)
            });
        }

        @Override
        public List<Coord[]> getDeltas() {
            return deltas;
        }

    }

    static class Z implements Tetromino {
        List<Coord[]> deltas;

        public Z() {

            deltas = new ArrayList<>();
            deltas.add(new Coord[]{
                    new Coord(0, 0),
                    new Coord(1, 0),
                    new Coord(1, 1),
                    new Coord(2, 1)
            });
            deltas.add(new Coord[]{
                    new Coord(0, 1),
                    new Coord(1, 0),
                    new Coord(1, 1),
                    new Coord(0, 2)
            });
            deltas.add(new Coord[]{
                    new Coord(1, 0),
                    new Coord(0, 1),
                    new Coord(1, 1),
                    new Coord(2, 0)
            });
            deltas.add(new Coord[]{
                    new Coord(0, 1),
                    new Coord(0, 0),
                    new Coord(1, 1),
                    new Coord(1, 2)
            });
        }

        @Override
        public List<Coord[]> getDeltas() {
            return deltas;
        }

    }

    static class Coord{
        int row;
        int col;

        public Coord(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}