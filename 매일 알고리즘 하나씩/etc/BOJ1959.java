package everyday.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1959 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long M = Long.parseLong(st.nextToken());
		long N = Long.parseLong(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		if(M > N){
			sb.append(((N - 1) * 2 + 1) + "\n");
		}
        else {
			sb.append(((M - 1) * 2) + "\n");
		}

		if(M == N){
			if(M % 2 == 1){
				sb.append((M / 2 + 1) + " " + (N / 2 + 1) + "\n");
			}
            else{
				sb.append((M / 2 + 1) + " " + (N / 2) + "\n");
			}
        }
        else if(M > N){
            if(N % 2 == 0){
                sb.append((N / 2 + 1) + " " + (N / 2) + "\n");
            }
            else{
                sb.append((N / 2 + 1 + (M - N)) + " " + (N / 2 + 1) + "\n");
            }
        }
        else{
            if(M % 2 == 0){
                sb.append((M / 2 + 1) + " " + (M / 2) + "\n");
            }
            else{
                sb.append((M / 2 + 1) + " " + (M / 2 + 1 + (N - M)) + "\n");
            }
        }
		System.out.println(sb);
	}
}