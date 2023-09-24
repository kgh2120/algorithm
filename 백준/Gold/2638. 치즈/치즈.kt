import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer



val br = BufferedReader(InputStreamReader(System.`in`));
var st:StringTokenizer? = null;
var matrix:Array<IntArray>? = null;
var q :Queue<IntArray> = LinkedList();
var nOfC = 0;
var n = 0;
var m = 0;
val deltas = arrayOf(intArrayOf(-1,0), intArrayOf(1,0),intArrayOf(0,-1),intArrayOf(0,1));
var visited:Array<IntArray>? = null;
fun main(){
    st = StringTokenizer(br.readLine());
    n = st!!.nextToken().toInt();
    m = st!!.nextToken().toInt();
    visited = Array(n){IntArray(m)};
    matrix = Array(n){ IntArray(m) }
    for (i: Int in 0 until n){
        st = StringTokenizer(br.readLine());
        for(j: Int in 0 until m){
            val num = st!!.nextToken().toInt();
            matrix!![i][j] = num;
            if(num == 1)
                nOfC++;
        }
    }

    var time = 0;
    q.add(intArrayOf(0,0));
    matrix!![0][0] = -1;
    while(nOfC > 0){
        ++time;
        bfs();
    }
    println(time)
}

fun bfs(){
    val next:Queue<IntArray> = LinkedList();


    while(!q.isEmpty()){
        val poll = q.poll();
        for(delta in deltas){
            val nr = poll[0] + delta[0];
            val nc = poll[1] + delta[1];

            if(canMove(nr,nc)){
                val num = matrix!![nr][nc];
                if(num == 0){
                    matrix!![nr][nc] = -1;
                    q.add(intArrayOf(nr,nc));
                }else{
                    if(visited!![nr][nc] >= 1){
                        matrix!![nr][nc] = -1;
                        nOfC--;
                        next.add(intArrayOf(nr,nc));
                    }else{
                        visited!![nr][nc]++;
                    }
                }

            }
        }
    }
    q = next;
}

fun canMove(row:Int, col : Int):Boolean{
    return row in 0 until n && col in 0 until m && matrix!![row][col] != -1;
}