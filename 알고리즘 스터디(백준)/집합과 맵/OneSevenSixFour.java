import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class OneSevenSixFour {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> notEar = new ArrayList<>();
        List<String> noEarSee = new ArrayList<>();

        for(int i = 0; i < N; i++){
            notEar.add(br.readLine());
        }
        for(int i = 0; i < M; i++){
            String notSee = br.readLine();
            if(notEar.contains(notSee)){
                noEarSee.add(notSee);
            }
        }
        Collections.sort(noEarSee);

        sb.append(noEarSee.size() + "\n");
        for(String str : noEarSee){
            sb.append(str + "\n");
        }
        System.out.println(sb);
    }
}
