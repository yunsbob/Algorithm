import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ24480 {
	static int[] visited;
	static List<ArrayList<Integer>> arr = new ArrayList<>();
	static int N, cnt = 1; // cnt는 몇 번째 방문인지 알려줌
	
	public static void DFS(int node) {
		visited[node] = cnt++; // 노드 방문
		
		Collections.sort(arr.get(node)); // 내림차순 방문 위해 정렬
		for(int i = arr.get(node).size() - 1; i >= 0; i--) { // 내림차 순으로 방문
			if(visited[arr.get(node).get(i)] == 0) { // 현재 노드와 연결된 i노드에 방문한 적이 없을 경우
				DFS(arr.get(node).get(i));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken()); // 노드 수
		int M = Integer.parseInt(st.nextToken()); // 간선 수
		int R = Integer.parseInt(st.nextToken()); // 시작 노드
		visited = new int[N + 1];
		
        for(int i = 0; i <= N; i++) { // 노드 추가
            arr.add(new ArrayList<>()); // 노드당 리스트 존재
        }
		for(int i = 0; i < M; i++) { // 노드 연결
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.get(a).add(b); // a - b 두 노드 연결 양방향 간선이므로 동시 입력
			arr.get(b).add(a); // a 리스트에 b 입력, b 리스트에 a 입력
		}
		
		DFS(R); // R부터 DFS 시작
		for(int i = 1; i <= N; i++){
			sb.append(visited[i]).append('\n');
		}
		System.out.println(sb);
	}
}