class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
         int j=0;
        for(int i=0; i<s; i++)
        {
            answer+=my_string.charAt(i);
            
        }
        for(int i=s; i<s+overwrite_string.length(); i++ )
        {   
        
            answer+=overwrite_string.charAt(j);
            if(j!=overwrite_string.length()-1)
            {
                j+=1;
            }
        }
        
        if(s+overwrite_string.length()!=my_string.length())
        {
           for(int i=s+overwrite_string.length(); i<my_string.length(); i++)
           {
              
                 answer+=my_string.charAt(i);
           }
        }
        return answer;
    }
}