package everyday.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16637 {
	static String expr;
	static int result = Integer.MIN_VALUE;

	static int calc(int sum, int now, char cal) {
		switch(cal) {
			case '+': return sum + now;
			case '-': return sum - now;
			case '*': return sum * now;
		}
		return 0;
	}
	
	static void cal(int idx, int sum) { // 현재 인덱스, 계산 결과
		if(idx >= expr.length()) {
			result = Math.max(result, sum);
			return;
		}
		
		cal(idx + 2, calc(sum, expr.charAt(idx) - '0', expr.charAt(idx - 1)));
		
		if(idx + 2 < expr.length()) {
			cal(idx + 4, calc(sum, calc(expr.charAt(idx) - '0', expr.charAt(idx + 2) - '0', expr.charAt(idx + 1)), expr.charAt(idx - 1)));
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		br.readLine();
		expr = br.readLine();
		
		cal(2, expr.charAt(0) - '0');
		
		System.out.println(result);
	}

}