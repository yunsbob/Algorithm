package everyday.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3036 {
    public static int gcd(int num1, int num2){
        if(num2 == 0) return num1;
        else return gcd(num2, num1 % num2);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] ring = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            ring[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N; i++){
            sb.append(ring[0] * ring[i] / gcd(ring[0], ring[i]) / ring[i] + "/" + ring[0] * ring[i] / gcd(ring[0], ring[i]) / ring[0] + "\n");
        }
        System.out.println(sb);
    }
}