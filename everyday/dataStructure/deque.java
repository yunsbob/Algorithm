package everyday.dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class deque {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Deque<String> deque = new ArrayDeque<>();
		String m;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			m = st.nextToken();
			if(m.equals("push_front")) {
				deque.addFirst(st.nextToken());
			}
			else if(m.equals("push_back")) {
				deque.addLast(st.nextToken());
			}
			else if(m.equals("pop_front")) {
				if(deque.size() == 0) {
					sb.append("-1\n");
				}
				else {
					sb.append(deque.pollFirst() + '\n');
				}
			}
			else if(m.equals("pop_back")) {
				if(deque.size() == 0) {
					sb.append("-1\n");
				}
				else {
					sb.append(deque.pollLast() + '\n');
				}
			}
			else if(m.equals("size")){
				sb.append(deque.size() + "\n");
			}
			else if(m.equals("empty")) {
				if(deque.size() == 0) {
					sb.append("1\n");
				}
				else {
					sb.append("0\n");
				}
			}
			else if(m.equals("front")) {
				if(deque.size() == 0) {
					sb.append("-1\n");
				}
				else {
					sb.append(deque.peekFirst() + '\n');
				}
			}
			else if(m.equals("back")) {
				if(deque.size() == 0) {
					sb.append("-1\n");
				}
				else {
					sb.append(deque.peekLast() + '\n');
				}
			}
		}
		System.out.println(sb);
	}
}