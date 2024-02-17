import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.parseInt
import java.lang.StringBuilder
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = parseInt(br.readLine())
    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        val a = parseInt(st.nextToken())
        val b = parseInt(st.nextToken())

        sb.append(a * b / gcd(a, b)).append('\n')
    }

    println(sb)
}

fun gcd(a: Int, b: Int): Int {
    if (b == 0) return a
    else return gcd(b, a % b)
}