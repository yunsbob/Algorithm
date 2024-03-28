import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static long[] memo;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        memo = new long[n + 1];

        bw.write(Fib(n) + "\n");
        bw.flush();
    }
    
    private static long Fib(int n){
        if(n <= 1){
            return n;
        }
        else if(memo[n] != 0){
            return memo[n];
        }
        else{
            return memo[n] = Fib(n - 1) + Fib(n - 2);
        }
    }
}