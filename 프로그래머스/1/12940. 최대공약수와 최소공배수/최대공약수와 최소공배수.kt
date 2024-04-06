class Solution {
    fun solution(n: Int, m: Int): IntArray {
        val answer = IntArray(2)
        
        answer[0] = gcd(n, m)
        answer[1] = n * m / answer[0]
        
        return answer
    }
    
    fun gcd(n: Int, m: Int): Int {
        if (m == 0) return n
        else return gcd(m, n % m)
    }
}