import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val str = br.readLine()
    val list = ArrayList<String>()
    str.indices.forEach {
        list.add(str.substring(it, str.length))
    }

    list.sort()
    for (s in list) {
        sb.append(s).append('\n')
    }

    println(sb)
}