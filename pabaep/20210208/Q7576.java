//https://sundries-in-myidea.tistory.com/17
import java.util.*;
import java.io.*;


//토마토의 좌표값
class tomato{
	int x;
	int y;
	public tomato(int x, int y){
	this.x = x;
	this.y = y;
	}
}

public class Q7576 {
	static int m,n, cm, cp ,check=-1;
	static int map[][], visited[][];
	static int dx[] ={0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static void bfs(){
		Queue<tomato> q = new LinkedList<tomato>();
		for(int i =1; i<n+1; i++){
			for(int j=1; j<m+1; j++ ){
				if(map[i][j]==1){
					visited[i][j] =1;
					q.offer(new tomato(i, j));
					cp++;
				}
				if(map[i][j]==-1){
					cm--;
				}
			}
		}
		if(cp==cm){
			check =0;
		}
		while(!q.isEmpty()){
			tomato temp = q.poll();
			map[temp.x][temp.y] =1;
			for(int i=0; i<4; i++ ){
				if(map[temp.x+dx[i]][temp.y+dy[i]] ==0 && visited[temp.x+dx[i]][temp.y+dy[i]]==0){
					q.offer(new tomato(temp.x+dx[i], temp.y+dy[i]));
					visited[temp.x+dx[i]] [temp.y+dy[i]] = visited[temp.x][temp.y] +1;
				}
			}
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tc = br.readLine();
		StringTokenizer st = new StringTokenizer(tc, " ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map= new int[n+2][m+2];
		visited = new int[n+2][m+2];
		for(int i =0; i<n+2; i++){
			Arrays.fill(visited[i], 0);
			Arrays.fill(map[i], -1);
		}
		for(int i=1; i<n+1; i++){
			String s = br.readLine();
			StringTokenizer st1 = new StringTokenizer(s, " ");
			for(int j=1; j<m+1; j++){
				map[i][j] = Integer.parseInt(st1.nextToken());
			}
		}
		bfs();
		int max = -1;
		boolean not = true;
		for(int i =1; i<n+1; i++){
			for(int j=1; j<m+1; j++ ){
				if(map[i][j]==0){
					not = false;
				}
				max = Math.max(max, visited[i][j]);
			}
		}
		if(!not){
			System.out.println(-1);
		}
		else{
			if(check==0){
				System.out.println(0);
			}
			else{
				System.out.println(max-1);
			}
		}


	}

}
