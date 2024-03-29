package everyday.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> site = new HashMap<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            site.put(st.nextToken(), st.nextToken());
        }

        for(int i = 0; i < M; i++){
            sb.append(site.get(br.readLine()) + '\n');
        }
        System.out.println(sb);
    }
}
