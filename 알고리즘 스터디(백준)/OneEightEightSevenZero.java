import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.IOException;

public class OneEightEightSevenZero {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] arr = new int [n][2];
        int cnt = 0;

        for(int i = 0; i < n; i++){
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0]; 
                }
            }
        });

        for(int i = 0; i < n; i++){
            if(i == n - 1)
                arr[i][0] = cnt;
            else if(arr[i][0] == arr[i+1][0]){
                arr[i][0] = cnt;
            }
            else{
                arr[i][0] = cnt++;
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }else {
                    return o1[1] - o2[1]; 
                }
            }
        });

        for(int i = 0; i < n; i++){
            bw.write(arr[i][0] + " ");
        }
        bw.flush();
    }
}