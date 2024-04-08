import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.LinkedList
import java.util.StringTokenizer

var N = 0
lateinit var matrix: Array<IntArray>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    var st = StringTokenizer(readLine())

    N = st.nextToken().toInt()
    val B = st.nextToken().toLong()
    matrix = Array(N) { IntArray(N) }
    for (i in 0 until N) {
        st = StringTokenizer(readLine())

        for (j in 0 until N) {
            matrix[i][j] = st.nextToken().toInt()
        }
    }

    val res = pow(B)
    for (i in 0 until N) {
        for (j in 0 until N) {
           sb.append(res[i][j] % 1000).append(' ')
        }
        sb.append('\n');
    }

    println(sb)
}

fun pow(cnt: Long): Array<IntArray> {
    if (cnt == 1L)
        return matrix

    val A = pow(cnt / 2)

    if (cnt % 2 == 0L)
        return cal(A, A)
    else
        return cal(A, cal(A, matrix))
}

fun cal(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
    val arr = Array(N) { IntArray(N) }
    for (i in 0 until N) {
        for (j in 0 until N) {
            for (k in 0 until N) {
                arr[i][j] += A[i][k] * B[k][j];
                arr[i][j] %= 1000;
            }
        }
    }

    return arr;
}