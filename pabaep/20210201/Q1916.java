import java.io.*;
import java.util.*;

public class Q1916 {
	static int distance[];
	static boolean visit[];
	static LinkedList<Node> list[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());//노드
		int m = Integer.parseInt(br.readLine());//간선
        visit = new boolean[n+1];
        list = new LinkedList[n+1];
        distance = new int[n+1];
        Arrays.fill(distance, -1);
        for(int i = 1; i <= n; i++)
            list[i] = new LinkedList<>();
		for(int i = 0; i<m ; i++) {
			st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());//각 노선별 출발
            int v2 = Integer.parseInt(st.nextToken());//각 노선별 도착
            int w = Integer.parseInt(st.nextToken());//간선가중치
            list[v1].add(new Node(v2, w));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());//출발도시
		int end = Integer.parseInt(st.nextToken());//도착도시
		dijkstra(start);
		System.out.println(distance[end]);
	}
	/*다익스트라 함수 정의*/
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		distance[start] = 0;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(!visit[now.num]) {
				visit[now.num] = true;
				for(Node next : list[now.num]) {
                    if(distance[next.num] == -1 || distance[next.num] > distance[now.num] + next.weight) {
                        distance[next.num] = distance[now.num] + next.weight;
                        pq.offer(new Node(next.num, distance[next.num]));
                    }
				}
			}
		}
	}
	/*노드 클래스*/
	static class Node implements Comparable<Node> {
		int num, weight;
		
		Node(int n, int w){
			this.num = n;
			this.weight = w;
		}
		
		@Override
		public int compareTo(Node n) {
			return weight - n.weight;
		}
		
	}
}
