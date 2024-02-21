import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.TreeSet

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val sb = StringBuilder()

    val str = readLine()
    val list = TreeSet<String>()
    val last = str.length
    str.indices.forEach {
        list.add(str.substring(it, last))
    }

    list.forEach { sb.append(it).append('\n') }

    println(sb)
}