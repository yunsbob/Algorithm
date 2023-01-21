import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneSixSevenSix {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        while (N >= 5){
            N /= 5;
            result += N;
        }

        sb.append(result);
        System.out.println(sb);
    }
}