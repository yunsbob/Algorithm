import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneFourThreeSix {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        int result = 666;
        
        while(cnt != N){
            result++;
            if(String.valueOf(result).contains("666")){
                cnt++;
            }
        }

        sb.append(result);
        System.out.println(sb);
    }
}