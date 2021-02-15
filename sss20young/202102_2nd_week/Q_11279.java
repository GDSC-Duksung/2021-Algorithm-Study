import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q_11279 {
    static int N, X;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1); // 내림차순

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            X = Integer.parseInt(br.readLine());

            if (X != 0) // X가 자연수
                priorityQueue.offer(X);
            else {
                if (priorityQueue.isEmpty())
                    sb.append(0+"\n");
                else
                    sb.append(priorityQueue.poll()+"\n");
            }
        }

        System.out.println(sb.toString());
    }
}