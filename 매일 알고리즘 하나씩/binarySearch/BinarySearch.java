package everyday.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class BinarySearch {
	static int[] arr;
	public static int binarySearch(int key, int left, int right) {
		int mid;

		if(left <= right) {
			mid = (left + right) / 2;

			if(key == arr[mid]) {
				return 1;
			}
			else if(key < arr[mid]) {
				return binarySearch(key ,left, mid-1);  
			}
			else { 
				return binarySearch(key, mid+1, right); 
			}
		}

		return 0;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < M; i++) {
			sb.append(binarySearch(Integer.parseInt(st.nextToken()), 0, N - 1) + "\n");
		}
		
		System.out.println(sb);
	}
}