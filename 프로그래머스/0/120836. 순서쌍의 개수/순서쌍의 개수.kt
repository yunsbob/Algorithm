import java.io.*

class Solution {
    fun solution(n: Int): Int {
        var res = 0
        for(i in 1..n) {
            for(j in 1..n) {
                if(i * j > n) break
                if(i * j == n) res++
            } 
        }
        return res
    }
}