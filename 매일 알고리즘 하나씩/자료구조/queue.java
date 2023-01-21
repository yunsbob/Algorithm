import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class queue {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Queue<String> queue = new LinkedList<>();
		String m, num;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			m = st.nextToken();
			if(m.equals("push")) {
				queue.add(st.nextToken());
			}
			else if(m.equals("pop")) {
				if(queue.size() == 0) {
					sb.append("-1\n");
				}
				else {
					sb.append(queue.poll() + '\n');
				}
			}
			else if(m.equals("size")){
				sb.append(queue.size() + "\n");
			}
			else if(m.equals("empty")) {
				if(queue.size() == 0) {
					sb.append("1\n");
				}
				else {
					sb.append("0\n");
				}
			}
			else if(m.equals("front")) {
				if(queue.size() == 0) {
					sb.append("-1\n");
				}
				else {
					sb.append(queue.peek() + '\n');
				}
			}
			else if(m.equals("back")) {
				if(queue.size() == 0) {
					sb.append("-1\n");
				}
				else {
					for(int cnt = 1; cnt <= queue.size(); cnt++) {
						if(cnt == queue.size()) {
							num = queue.poll();
							sb.append(num + '\n');
							queue.add(num);
						}
						else {
							num = queue.poll();
							queue.add(num);
						}
					}
				}
			}
		}
		System.out.println(sb);
	}
}