import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val arr = MutableList(N){st.nextToken().toInt()}

    arr.sort()
    var res = 0
    for (i in 0 until N) {
        var s = 0
        var e = N - 1
        val num = arr[i]

        while (s < e) {
            if (s == i) {
                s++
                continue
            } else if (e == i) {
                e--
                continue
            }

            val sum = arr[s] + arr[e]
            if (sum < num) s++
            else if (sum > num) e--
            else {
                res++
                break
            }
        }
    }

    println(res)
}