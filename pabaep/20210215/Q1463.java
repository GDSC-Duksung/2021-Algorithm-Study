import java.io.*;

public class Q1463 {
	static Integer [] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		dp = new Integer [n+1];
		dp[0] = dp[1] = 0;
		
		System.out.println(cal(n));

	}
	
	static int cal(int n) {
		if (dp[n] == null) {
			// 6으로 나눠지는 경우 
			if (n % 6 == 0) {
				dp[n] = Math.min(cal(n - 1), Math.min(cal(n / 3), cal(n / 2))) + 1;
			}
			// 3으로만 나눠지는 경우 
			else if (n % 3 == 0) {
				dp[n] = Math.min(cal(n / 3), cal(n - 1)) + 1;
			}
			// 2로만 나눠지는 경우 
			else if (n % 2 == 0) {
				dp[n] = Math.min(cal(n / 2), cal(n - 1)) + 1;
			}
			// 2와 3으로 나누어지지 않는 경우
			else {
				dp[n] = cal(n - 1) + 1;
			}
		}
		return dp[n];
	}
}

