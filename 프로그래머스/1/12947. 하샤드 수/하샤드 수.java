class Solution {
    public boolean solution(int x) {
        String s = String.valueOf(x);
        int num = 0;
        
        for (int i = 0; i < s.length(); i++) {
            num += s.charAt(i) - '0';
        }
        
        return x % num == 0;
    }
}