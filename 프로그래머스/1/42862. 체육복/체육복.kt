 class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val check = BooleanArray(n + 2){true}
        val lostList = lost.toMutableList()
        val reserveList = reserve.toMutableList()
        val removeList = mutableListOf<Int>()
        
        lostList.forEach{
            if (reserveList.contains(it)) {
                removeList.add(it)
            }
        }
        lostList.removeAll(removeList)
        reserveList.removeAll(removeList)

        lostList.forEach { check[it] = false }
        
        lostList.sort()
        reserveList.sort()
        reserveList.forEach {
            if (!check[it - 1]) {
                check[it - 1] = true
            } else if(!check[it + 1]) {
                check[it + 1] = true
            }
        }
        
        return check.count {it} - 2
    }
}