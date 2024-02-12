class Solution {
    fun solution(answers: IntArray): IntArray {
        val cnt = intArrayOf(0, 0, 0)
        val ans1 = intArrayOf(1, 2, 3, 4, 5)
        val ans2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val ans3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        
        for (i in 0 until answers.size) {
            if (ans1[i % 5] == answers[i]) {
                cnt[0]++
            }
            if (ans2[i % 8] == answers[i]) {
                cnt[1]++
            }
            if (ans3[i % 10] == answers[i]) {
                cnt[2]++
            }
        }
    
        val max = maxOf(cnt[0], cnt[1], cnt[2])
        val answer = mutableListOf<Int>()
        if (max == cnt[0]) {
            answer.add(1)
        }
        if (max == cnt[1]) {
            answer.add(2)
        }
        if (max == cnt[2]) {
            answer.add(3)
        }
    
        return answer.toIntArray()
    }
}