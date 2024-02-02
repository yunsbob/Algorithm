import java.util.*

fun main() {
    val scan = Scanner(System.`in`)
    var t1 = scan.nextInt()
    var e1 = scan.nextInt()
    var f1 = scan.nextInt()
    var t2 = scan.nextInt()
    var e2 = scan.nextInt()
    var f2 = scan.nextInt()
    var Max = t1 * 3 + e1 * 20 + f1 * 120
    var Mel = t2 * 3 + e2 * 20 + f2 * 120

    if (Max > Mel) println("Max")
    else if(Mel > Max) println("Mel")
    else println("Draw")
}