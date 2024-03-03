import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val arr = IntArray(n){st.nextToken().toInt()}
    val s = readLine().toInt()

    println(bfs(s, n, arr))
}

fun bfs(s: Int, max: Int, arr: IntArray): Int {
    var res = 1
    val visited = BooleanArray(max)
    val q = LinkedList<Int>()
    q.add(s - 1)
    visited[s - 1] = true

    while (!q.isEmpty()) {
        val now = q.poll()
        var next = now - arr[now]
        
        if (next >= 0 && !visited[next]) {
            res++
            visited[next] = true
            q.add(next)
        }

        next = now + arr[now]
        if (next < max && !visited[next]) {
            res++
            visited[next] = true
            q.add(next)
        }
    }

    return res
}