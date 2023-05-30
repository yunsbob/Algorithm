package everyday.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class BOJ7576 {
	static int[][] graph;
	static Queue<Integer> queueY = new LinkedList<>();
    static Queue<Integer> queueX = new LinkedList<>();
	static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int tmtCheck = 0;
    static int[][] day;
	public static void BFS() {
        int nodeX, nodeY, x, y;
		while(!queueY.isEmpty()) {
			nodeX = queueX.poll();
            nodeY = queueY.poll();

			for(int i = 0; i < 4; i++) {
                x = nodeX + dx[i];
                y = nodeY + dy[i];
                if(x >= 0 && y >= 0 && x < M && y < N && graph[y][x] == 0){
                    queueX.offer(x);
                    queueY.offer(y);
                    graph[y][x] = 1;
                    tmtCheck++;
                    day[y][x] = day[nodeY][nodeX] + 1;
                }
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
        day = new int[N][M];
        int tmtCnt = 0;
        int result = 0;

		for(int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
            for(int x = 0; x < M; x++){
                graph[y][x] = Integer.parseInt(st.nextToken());
                if(graph[y][x] == 0){
                    tmtCnt++;
                }
                else if(graph[y][x] == 1){
                    queueX.offer(x);
                    queueY.offer(y);
                }
            }
		}
        if(tmtCnt != 0){
            BFS();
            if(tmtCnt != tmtCheck){
                result = -1;
            }
            else{
                for(int y = 0; y < N; y++){
                    for(int x = 0; x < M; x++){
                        if(result < day[y][x]){
                            result = day[y][x];
                        }
                    }
                }
            }
        }
        sb.append(result);
		System.out.println(sb);
	}
}