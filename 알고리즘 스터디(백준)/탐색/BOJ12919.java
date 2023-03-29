package study.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ12919 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder after = new StringBuilder();
    	String before = br.readLine();
    	after.append(br.readLine());
    	
    	while(before.length() != after.length()) {
    		if(after.charAt(after.length() - 1) == 'B') {
    			after.deleteCharAt(after.length() - 1);
    			after = after.reverse();
    		}
    		else {
    			after.deleteCharAt(after.length() - 1);
    		}
    	}
    	if(before.equals(after.toString())) System.out.println(1);
    	else System.out.println(0);
    }
}