import java.util.*;

public class Q11279 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());//큰 숫자를 제일 상단에
		StringBuilder sb = new StringBuilder();
		int n = s.nextInt();
		for(int i = 0;i<n;i++) {
			int tmp = s.nextInt();
			if(tmp == 0) {
				if(pq.isEmpty()) {
					sb.append(0 + "\n");
				}
				else {
					sb.append(pq.poll() + "\n");
				}
			}
			else {
				pq.add(tmp);
			}
		}
		System.out.println(sb);
	}

}
