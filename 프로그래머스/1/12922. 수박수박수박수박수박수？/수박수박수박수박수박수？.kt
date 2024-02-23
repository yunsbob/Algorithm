class Solution {
    fun solution(n: Int): String {
        var answer = ""
        
        repeat(n) {
            answer += if (it % 2 == 0) "수" else "박"
        }
        return answer
    }
}