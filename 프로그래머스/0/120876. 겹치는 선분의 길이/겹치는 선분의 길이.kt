class Solution {
    fun solution(lines: Array<IntArray>): Int {
        val res = MutableList<Int>(201){0}
        lines.forEach { l ->
            for(i in l[0]..l[1] - 1) {
                res[i + 100]++
            }
        }
        return res.count{r -> r >= 2}
    }
}