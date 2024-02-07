import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val s1 = br.readLine()
    val s2 = br.readLine()
    val dp = Array(s1.length + 1) {IntArray(s2.length + 1)}

    var res = 0
    s1.forEachIndexed { i, c1 ->
        s2.forEachIndexed { j, c2 ->
            if (c1 == c2) {
                dp[i + 1][j + 1] = dp[i][j] + 1
                res = max(res, dp[i + 1][j + 1])
            }
        }
    }

    println(res)
}