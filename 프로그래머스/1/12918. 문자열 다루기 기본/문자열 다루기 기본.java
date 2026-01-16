class Solution {
    public boolean solution(String s) {
        int len = s.length();
        
        if (len == 4 || len == 6) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) < '0' || '9' < s.charAt(i)) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }
}