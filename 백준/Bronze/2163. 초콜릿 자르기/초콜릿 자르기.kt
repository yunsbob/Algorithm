import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.parseInt
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val n = parseInt(st.nextToken())
    val m = parseInt(st.nextToken())
    
    println(n * m - 1)
}