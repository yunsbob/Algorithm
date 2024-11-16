class Solution {
    public int[] solution(String s) {
        int[] res = new int[2];
        
        while (!s.equals("1")) {
            res[0]++;
            
            int cnt = 0, len = s.length();
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '0') {
                    cnt++;
                }
            }
            
            res[1] += cnt;
            len -= cnt;
            s = Integer.toBinaryString(len);
        }
        
        return res;
    }
}