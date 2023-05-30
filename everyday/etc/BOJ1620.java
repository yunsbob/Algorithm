package everyday.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1620 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> pokemon = new HashMap<>();
        List<String> pokemonName = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            String name = br.readLine();
            pokemon.put(name, i);
            pokemonName.add(name);
        }
        for(int i = 0; i < M; i++){
            String str = br.readLine();
            if(str.charAt(0) > '0' && str.charAt(0) <= '9'){
                sb.append(pokemonName.get(Integer.parseInt(str) - 1) + "\n");
            }
            else{
                sb.append(pokemon.get(str) + "\n");
            }
        }

        System.out.println(sb);
    }
}
