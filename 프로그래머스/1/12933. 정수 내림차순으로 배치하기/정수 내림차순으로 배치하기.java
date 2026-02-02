class Solution {
    public long solution(long n) {
        String s = String.valueOf(n);
        int[] cnt = new int[10];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - '0']++;
        }
        
        String res = "";
        for (int i = 9; i >= 0; i--) {
            while (cnt[i] != 0) {
                res += String.valueOf(i);
                cnt[i]--;
            }
        }
        
        return Long.valueOf(res);
    }
}