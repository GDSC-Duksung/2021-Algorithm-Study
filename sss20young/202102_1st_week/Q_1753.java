import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q_1753 {
    static int V, E, K;
    static PriorityQueue<Graph> priorityQueue = new PriorityQueue<>();
    static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken()); // 시작 노드
        
        ArrayList<ArrayList<Graph>> array = new ArrayList<ArrayList<Graph>>();
        for (int i = 0; i <= V; i++) {
            array.add(new ArrayList<Graph>());
        }

        int start, end, weight;
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            array.get(start).add(new Graph(end, weight));
        }

        int[] distance = new int[V+1];
        int[] visited = new int[V+1];
        Arrays.fill(distance, INF); // distance를 INF로 채우기
        priorityQueue.offer(new Graph(K, 0));
        distance[K] = 0;
        while(!priorityQueue.isEmpty()) {
            // STEP 1: 집합에 들어있는 노드로부터 아직 방문하지 않은 노드까지의 거리를 구한다.
            int w = priorityQueue.poll().end;
            if (visited[w] == 1)
                continue;

            visited[w] = 1;
            
            // dijkstra 알고리즘
            for (Graph g : array.get(w)) {
                if (distance[g.end] > distance[w] + g.weight) { 
                    distance[g.end] = distance[w] + g.weight;
                     // STEP 2: 최소값을 갖는 노드를 찾아 priorityQueue에 넣는다.
                    priorityQueue.add(new Graph(g.end, distance[g.end]));
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            if (distance[i] != INF)
                sb.append(distance[i]+"\n");
            else 
                sb.append("INF\n");
        }

        System.out.println(sb);
    }
}

// array 배열에 시작노드부터 end노드까지의 weight를 표현하기 위함
class Graph implements Comparable<Graph> {
    int end;
    int weight;

    Graph(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Graph g) {
        return this.weight - g.weight;
    }
}