package everyday.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ1918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		Deque<Character> stack = new ArrayDeque<>();

		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '+' || str.charAt(i) == '-') {
				if(!stack.isEmpty() && stack.getLast() != '(') {
					while(!stack.isEmpty() && stack.getLast() != '(') sb.append(stack.pollLast());
					stack.offerLast(str.charAt(i));
				}
				else {
					stack.offerLast(str.charAt(i));
				}
			}
			else if(str.charAt(i) == '*' || str.charAt(i) == '/') {
				if(!stack.isEmpty() && (stack.getLast() == '*' || stack.getLast() == '/')) {
					sb.append(stack.pollLast());
					stack.offerLast(str.charAt(i));
				}
				else {
					stack.offerLast(str.charAt(i));
				}
			}
			else if(str.charAt(i) == '(') {
				stack.offerLast(str.charAt(i));
			}
			else if(str.charAt(i) == ')') {
				while(stack.getLast() != '(') {
					sb.append(stack.pollLast());
				}
				stack.pollLast();
			}
			else {
				sb.append(str.charAt(i));
			}
		}
		while(!stack.isEmpty()) sb.append(stack.pollLast());
		System.out.println(sb);
	}
}