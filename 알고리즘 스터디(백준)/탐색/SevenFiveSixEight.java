import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SevenFiveSixEight {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
        int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
        
		for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			int rank = 1;
			for(int j = 0; j < N; j++) {
				if(i == j) continue; // 같을 때는 같은 등수
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) { // 큰 사람이 존재하면 등수 떨어짐
					rank++;
				}
			}
			sb.append(rank + " ");
		}
		System.out.println(sb);
	}
}