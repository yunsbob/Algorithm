import kotlin.math.*

class Solution {
    fun solution(distance: Int, rocks: IntArray, n: Int): Int {
        rocks.sort()
        var l = 0
        var r = distance
        var res = 0
        
        while(l <= r) {
            val mid = (l + r) / 2
            var dis = 0
            var cnt = 0
            
            for(rock in rocks) {
                if(rock - dis < mid) cnt++
                else dis = rock
            }
            
            if(distance - dis < mid) cnt++
            if(cnt > n) r = mid -1
            else {
                res = max(res, mid)
                l = mid + 1
            }
        }
        
        return res
    }
}