class Solution {
    lateinit var memo: IntArray
    
    fun solution(n: Int): Int {
        memo = IntArray(n + 1){-1}
        memo[0] = 0
        memo[1] = 1
        
        return fib(n)
    }
    
    fun fib(n: Int): Int{
        if (memo[n] != -1) {
            return memo[n]
        }
        
        memo[n] = fib(n - 1) + fib(n - 2)
        memo[n] = memo[n] % 1234567
        
        return memo[n]
    }
}