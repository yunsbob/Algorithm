import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class OneZeroEightOneSix {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] card = new int[20000001];
		int N = Integer.parseInt(br.readLine());
		int num;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			if(num >= 0) {
				card[num]++;
			}
			else {
				card[num * (-1) + 10000000]++;
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < M; i++) {
			num = Integer.parseInt(st.nextToken());
			if(num >= 0) {
				sb.append(card[num] + " ");
			}
			else {
				sb.append(card[num * (-1) + 10000000] + " ");
			}
		}

		System.out.println(sb);
	}
}