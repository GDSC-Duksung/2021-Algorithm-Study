import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q_1916 {
    static int N, M;
    static int S, E;
    static PriorityQueue<Graph> priorityQueue = new PriorityQueue<>();
    static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 도시 개수
        M = Integer.parseInt(br.readLine()); // 버스 개수
        
        ArrayList<ArrayList<Graph>> array = new ArrayList<ArrayList<Graph>>();
        for (int i = 0; i <= N; i++) {
            array.add(new ArrayList<Graph>());
        }

        int start, end, weight;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            array.get(start).add(new Graph(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()); // 시작 도시
        E = Integer.parseInt(st.nextToken()); // 도착 도시

        int[] distance = new int[N+1];
        int[] visited = new int[N+1];
        Arrays.fill(distance, INF); // distance를 INF로 채우기
        priorityQueue.offer(new Graph(S, 0));
        distance[S] = 0;
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
        System.out.println(distance[E]);
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
}