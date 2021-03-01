import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_2981 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Long[] n = new Long[N];
        for (int i = 0; i < N; i++) {
            n[i] = Long.parseLong(br.readLine());
        }

        // 오름차순 정렬
        Arrays.sort(n);

        // 인접 수끼리 최대공약수 구하기
        long r = n[1]-n[0];
        for (int i = 2; i < N; i++) {
            r = GCD(r, n[i]-n[i-1]);
        }

        // 최대공약수의 약수들
        for (long i = 2; i <= r/2; i++) {
            if (r % i == 0)
                sb.append(i+" ");
        }

        sb.append(r);

        System.out.println(sb.toString());
    }

    // 최대공약수
    public static long GCD(long a, long b) {
        while (b != 0) { // 나누어 떨어지지 않음
            long temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }
}