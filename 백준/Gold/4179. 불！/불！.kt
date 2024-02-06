import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

var R = 0
var C = 0
lateinit var map: Array<CharArray>
val dr = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))
val jh: Queue<XY> = LinkedList()
val fire: Queue<XY> = LinkedList()

class XY(val x: Int, val y: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    R = st.nextToken().toInt()
    C = st.nextToken().toInt()
    map = Array(R) { CharArray(C) }

    var sx = 0
    var sy = 0
    repeat(R) {i ->
        val str = br.readLine()
        str.forEachIndexed { j, c ->
            map[i][j] = c
            when (c) {
                'J' -> {
                    sx = i
                    sy = j
                    map[i][j] = '.'
                    jh.offer(XY(sx, sy))
                }
                'F' -> fire.offer(XY(i, j))
            }
        }
    }

    val res = bfs(sx, sy)
    println(if (res == -1) "IMPOSSIBLE" else res)
}

fun bfs(sx: Int, sy: Int): Int {
    val visited = Array(R) {BooleanArray(C)}
    visited[sx][sy] = true

    var cnt = 1
    while (!jh.isEmpty()) {
        var size = jh.size
        while (size-- > 0) {
            val now = jh.poll()
            if (map[now.x][now.y] == 'F') continue
            repeat(4) { i ->
                val nx = now.x + dr[i][0];
                val ny = now.y + dr[i][1];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) return cnt
                if (map[nx][ny] == '.' && !visited[nx][ny]) {
                    visited[nx][ny] = true
                    jh.offer(XY(nx, ny))
                }
            }
        }

        size = fire.size
        while (size-- > 0) {
            val now = fire.poll()
            repeat(4) { i ->
                val nx = now.x + dr[i][0];
                val ny = now.y + dr[i][1];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == 'F' || map[nx][ny] == '#') return@repeat
                map[nx][ny] = 'F';
                fire.offer(XY(nx, ny));
            }
        }

        cnt++
    }

    return -1
}