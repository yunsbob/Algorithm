import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class stack {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Stack<String> stack = new Stack<>();
		String m;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			m = st.nextToken();
			if(m.equals("push")) {
				stack.push(st.nextToken());
			}
			else if(m.equals("pop")) {
				if(stack.empty()) {
					sb.append("-1\n");
				}
				else {
					sb.append(stack.pop() + '\n');
				}
			}
			else if(m.equals("size")){
				sb.append(stack.size() + "\n");
			}
			else if(m.equals("empty")) {
				if(stack.empty()) {
					sb.append("1\n");
				}
				else {
					sb.append("0\n");
				}
			}
			else if(m.equals("top")) {
				if(stack.empty()) {
					sb.append("-1\n");
				}
				else {
					sb.append(stack.peek() + '\n');
				}
			}
		}
		System.out.println(sb);
	}
}