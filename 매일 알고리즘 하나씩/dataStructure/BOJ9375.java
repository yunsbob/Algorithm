package everyday.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ9375 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            HashMap<String, Integer> fashion = new HashMap<>();
            List<String> w = new ArrayList<>();
            int result = 1;

            for(int j = 0; j < N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String wear = st.nextToken();
                if(fashion.containsKey(wear)){
                    fashion.put(wear, fashion.get(wear) + 1);
                }
                else{
                    fashion.put(wear, 1);
                    w.add(wear);
                }
            }

            for(int j = 0; j < w.size(); j++){
                result *= (fashion.get(w.get(j)) + 1);
            }
            sb.append(result - 1 + "\n");
        }
        System.out.println(sb);
    }
}