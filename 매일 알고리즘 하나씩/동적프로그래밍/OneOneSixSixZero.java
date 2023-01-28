import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OneOneSixSixZero {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] sum = new int[N+1][N+1];
        
        for(int y = 1; y <= N; y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 1; x <= N; x++){
                sum[y][x] = Integer.parseInt(st.nextToken()) + sum[y][x-1];
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x1, x2, y1, y2;
            y1 = Integer.parseInt(st.nextToken());
            x1 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            int result = 0;
            for(int y = y1; y <= y2; y++){
                result += sum[y][x2] - sum[y][x1 - 1];
            }
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}
