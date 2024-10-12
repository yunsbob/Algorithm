class Solution {
    public String solution(String phone_number) {
        String answer = "";
        int i = 0;
        for (i = 0; i < phone_number.length() - 4; i++) {
            answer += "*";
        }
        
        return answer + phone_number.substring(i, phone_number.length());
    }
}