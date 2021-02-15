import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_7576 {
    static int N, M;
    static int[][] array, visited;
    static int numberOfRipeTomatoes = 0; // 익은 토마토의 수
    static int numberOfRawTomatoes = 0; // 익지 않은 토마토의 수
    static int numberOfEmptyTomatoes = 0; // 토마토가 들어있지 않은 칸의 수
    static Queue<Position> queue = new LinkedList<Position>();
    static Queue<Position> queue2 = new LinkedList<Position>();
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int days = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        array = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());

                if (array[i][j] == 1) {
                    numberOfRipeTomatoes += 1;
                    queue.offer(new Position(i, j));
                }
                else if (array[i][j] == 0)
                    numberOfRawTomatoes += 1;
                else if (array[i][j] == -1)
                    numberOfEmptyTomatoes += 1;
            }
        }

        // 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력
        if (N*M - numberOfEmptyTomatoes == numberOfRipeTomatoes) {
            System.out.println(0);
        } else {
            BFS();

            if (numberOfRawTomatoes != 0) // 토마토가 모두 익지는 못하는 상황이면 -1을 출력
                System.out.println(-1);
            else // 토마토가 모두 익을 때까지의 최소날짜 출력
                System.out.println(days);
        }
    }

    public static void BFS() {         
        
        Position p;
        int x, y;

        while(!queue.isEmpty()) {
            p = queue.poll();
            x = p.x;
            y = p.y;
            visited[x][y] = 1;

            for (int i = 0; i < 4; i++) {
                int xMove = dx[i];
                int yMove = dy[i];

                if (x+xMove >= 0 && x+xMove < N && y+yMove >=0 && y+yMove < M) {
                    if (array[x+xMove][y+yMove] == 0 && visited[x+xMove][y+yMove] == 0) {
                        array[x+xMove][y+yMove] = 1;
                        numberOfRipeTomatoes += 1;
                        numberOfRawTomatoes -= 1;

                        queue2.offer(new Position(x+xMove, y+yMove));
                    }
                }
            }
        }

        if (!queue2.isEmpty()) {
            int size = queue2.size();
            for (int i = 0; i < size; i++) {
                p = queue2.poll();
                queue.offer(new Position(p.x, p.y));
            }
            
            days++;
            BFS();
        }
    }

    static class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}