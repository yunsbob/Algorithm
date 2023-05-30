package everyday.etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ10989 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];

        for(int i = 0; i < n; i++){
            int m = Integer.parseInt(br.readLine());
            arr[m]++;
        }

        for(int i = 0; i < 10001; i++){
            for(int j = 0; j < arr[i]; j++){
                bw.write(i + "\n");
            }
        }
        bw.flush();
    }
}
