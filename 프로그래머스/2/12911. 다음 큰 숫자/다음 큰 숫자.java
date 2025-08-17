class Solution {
    public int solution(int n) {
        int m = n;
        while(Integer.bitCount(n) != Integer.bitCount(++m)) {}
        
        return m;
    }
}