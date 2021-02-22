# 7576번: 토마토, BFS 이용(주변이 익기 때문)
import sys
from collections import deque # 시간초과를 막기위해 deque사용


def bfs(m,n,s):
    # 이동할 네 가지 방향 정의(좌우상하)
    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]

    days=-1

    while queue:
        days +=1
        for _ in range(len(queue)):
            x,y=queue.popleft()

            for i in range(4):
                nx=x+dx[i]
                ny=y+dy[i]

            if (0 <= nx < N) and (0 <= ny < M) and (s[nx][ny] == 0):
                s[nx][ny] = s[x][y] + 1
                queue.append([nx, ny])
    for b in s:
        if 0 in b:
            return -1
    return days




r=sys.stdin.readline
m, n= map(int, r().split())
s=[]
queue=deque()

for i in range(n):
    row=list(map(int, r().split()))
    for j in range(m):
        if row[j]==1:
            queue.append([i,j])
        s.append(row)

print(bfs(m,n,s))