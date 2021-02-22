import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][10];
        long sum = 0;

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1; 
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0)
                    dp[i][j+1] += dp[i-1][j]%1000000000; // 큰 수
                else if (j == 9)
                    dp[i][j-1] += dp[i-1][j]%1000000000; // 작은수
                else {
                    dp[i][j-1] += dp[i-1][j]%1000000000; // 작은수
                    dp[i][j+1] += dp[i-1][j]%1000000000; // 큰 수
                }
            }
        }

        for (int i = 0; i <= 9; i++) {
            sum += dp[N][i];
        }
        
        System.out.println(sum%1000000000);
    }
}