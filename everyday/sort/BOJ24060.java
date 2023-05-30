package everyday.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ24060 {
    public static int[] sortedArr;
    public static int num, cnt;
    public static void merge(int[] arr, int left, int mid, int right){
        int i = left;
        int j = mid + 1;
        int k = left;
        
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                sortedArr[k++] = arr[i++];
            }
            else{
                sortedArr[k++] = arr[j++];
            }
        }

        if(i > mid){
            for(int n = j; n <= right; n++){
                sortedArr[k++] = arr[n];
            }
        }

        else{
            for(int n = i; n <= mid; n++){
                sortedArr[k++] = arr[n];
            }
        }

        for(int n = left; n <= right; n++){
            cnt++;
            if(cnt == num){
                System.out.println(sortedArr[n]);
                System.exit(0);
            }
            arr[n] = sortedArr[n];
        }
    }

    public static void mergeSort(int arr[], int left, int right){    
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid); 
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());
        cnt = 0;

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        sortedArr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, n - 1);

        System.out.println("-1");
    }
}
