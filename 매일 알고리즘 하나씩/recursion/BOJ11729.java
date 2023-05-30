package everyday.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ11729 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int cnt = 0;

    public static void H(int start, int x, int arrive, int n) throws IOException {
        if(n == 1){
            bw.write(start + " " + arrive + "\n");
            cnt++;
            return;
        }

        H(start, arrive, x, n - 1);
        bw.write(start + " " + arrive + "\n");
        cnt++;
        H(x , start, arrive, n - 1);

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        H(1,2,3, n);
        System.out.println(cnt);
        bw.flush();
    }
}