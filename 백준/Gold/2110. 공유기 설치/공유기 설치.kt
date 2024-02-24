import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val st = StringTokenizer(readLine())

    val N = st.nextToken().toInt()
    val C = st.nextToken().toInt()
    val arr = IntArray(N) { readLine().toInt() }.apply { sort() }

    var min = 1
    var max = arr[N - 1] - arr[0]
    while (min <= max) {
        val mid = (min + max) / 2

        var cnt = 1
        var last = arr[0]
        arr.forEach {
            if (it - last >= mid) {
                cnt++
                last = it
            }
        }

        if (cnt < C) {
            max = mid - 1
        } else {
            min = mid + 1
        }
    }

    println(min - 1)
}