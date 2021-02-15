import java.io.*;
import java.util.*;

public class Q1753 {
    
    static LinkedList<Node> list[];
    static int distance[];
    static boolean visit[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드
        int m = Integer.parseInt(st.nextToken()); // 간선
        int start = Integer.parseInt(br.readLine()); // 시작 노드
        visit = new boolean[n+1];
        list = new LinkedList[n+1];
        distance = new int[n+1]; // 거리배열
        Arrays.fill(distance, -1);
        for(int i = 1; i <= n; i++)
            list[i] = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[v1].add(new Node(v2, w));
        }
        
        dijkstra(start);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++)
            sb.append(distance[i] == -1 ? "INF" : distance[i]).append("\n");
        System.out.print(sb.toString());
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(!visit[now.number]) {
                visit[now.number] = true;
                for(Node next : list[now.number]) {
                    if(distance[next.number] == -1 || distance[next.number] > distance[now.number] + next.weight) {
                        distance[next.number] = distance[now.number] + next.weight;
                        pq.offer(new Node(next.number, distance[next.number]));
                    }
                }
            }
        }
    }
    
    static class Node implements Comparable<Node> {
        int number, weight;
        
        Node(int n, int w) {
            this.number = n;
            this.weight = w;
        }
        
        public int compareTo(Node n) {
            return weight - n.weight;
        }
    }
}
