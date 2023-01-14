import java.util.Scanner;

public class TwoFiveSixThree {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] m = new int[100][100];
        int result = 0;

        for(int i = 0; i < n; i++){ // 좌표 입력
            int x = in.nextInt();
            int y = in.nextInt();

            for(int j = y; j < y+10; j++) // 10 x 10 색종이 붙이기
                for(int k = x; k < x+10; k++)
                    m[j][k] = 1;
        }
        in.close();

        for(int i = 0; i < 100; i++) // 100 x 100 도화지 검사
            for(int j = 0; j < 100; j++)
                if(m[i][j] == 1) result++; // 색종이 붙은 영역 카운트

        System.out.println(result);
    }
}