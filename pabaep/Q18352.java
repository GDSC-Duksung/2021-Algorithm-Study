import java.io.*;
import java.util.*;

public class Q18352 {
	static int distance[];
	public static ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());//노드
		int m = Integer.parseInt(st.nextToken());//간선
		int k = Integer.parseInt(st.nextToken());//찾는 거리
		int start = Integer.parseInt(st.nextToken());//출발도시
		distance = new int[n+1];
		for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<Integer>());
            distance[i] = -1;
        }
		distance[start] = 0;
		for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            al.get(a).add(b);
        }
		Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < al.get(now).size(); i++) {
                int nextNode = al.get(now).get(i);

                if (distance[nextNode] == -1) {
                	distance[nextNode] = distance[now] + 1;
                    q.offer(nextNode);
                }
            }
        }
        boolean check = false;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                check = true;
            }
        }
        if (!check) {
            System.out.println(-1);
        }
	}
}
