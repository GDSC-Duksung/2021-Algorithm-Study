from collections import deque
import sys

n, m, k, start = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(n+1)]
blist = [-1 for _ in range(n+1)]
for i in range(m):
    dep, arr = map(int, sys.stdin.readline().split())
    graph[dep].append(arr)

def bfs(start):
    q = deque([start])
    blist[start] = 0

    while q:
        city = q.popleft()
        for n_city in graph[city]:
            if blist[n_city] == -1:
                blist[n_city] = blist[city]+1
                q.append(n_city)

    return blist

answer = bfs(start)
if k not in answer:
    print(-1)
else:
    for i, v in enumerate(answer):
        if v == k:
            print(i)

