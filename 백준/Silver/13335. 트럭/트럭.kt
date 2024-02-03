import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, w, L) = br.readLine().split(' ').map { it.toInt() }
    val list = br.readLine().split(' ').map { it.toInt() }
    val truck: Queue<Int> = LinkedList()
    val bridge: Queue<Int> = LinkedList()
    for (l in list) {
        truck.offer(l)
    }
    for (i in 1..w) {
        bridge.offer(0)
    }

    var time = 0
    var now = 0
    while (!bridge.isEmpty()) {
        time++
        now -= bridge.poll()
        if (!truck.isEmpty()) {
            if (truck.peek() + now <= L) {
                var weight = truck.poll()
                now += weight
                bridge.offer(weight)
            }
            else {
                bridge.offer(0)
            }
        }
    }

    println(time)
}