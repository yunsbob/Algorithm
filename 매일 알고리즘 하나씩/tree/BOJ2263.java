package everyday.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2263 {
	static int N;
	static int[] inOrder, postOrder, idx;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		inOrder = new int[N + 1];
		postOrder = new int[N + 1];
		idx = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= N; i++) {
			idx[inOrder[i]] = i;
		}
		
		preOrder(1, N, 1, N);
		System.out.println(sb);
	}

	private static void preOrder(int inStart, int inEnd, int poStart, int poEnd) {
		if(inStart > inEnd || poStart > poEnd) return;
		
		int root = postOrder[poEnd];
		sb.append(root).append(' ');
		
		int rootIdx = idx[root];
		int left = rootIdx - inStart;
		
		preOrder(inStart, rootIdx - 1, poStart, poStart + left - 1);
		preOrder(rootIdx + 1, inEnd, poStart + left, poEnd - 1);
		
	}

}
