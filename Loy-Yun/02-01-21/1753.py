from heapq import heappush, heappop
import sys

INF = 1e9

def dijkstra(start):
    dlist[start] = 0
    h = []
    heappush(h, [0, start])

    while h:
        w, c = heappop(h)

        if dlist[c] < w:
            continue
        for wei, n_n in graph[c]:
            n_w = wei+w
            if n_w < dlist[n_n]:
                dlist[n_n] = n_w
                heappush(h, (n_w, n_n))

n, e = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n+1)]
dlist = [INF] * (n+1)
start = int(sys.stdin.readline())

for i in range(e):
    x, y, z = map(int, sys.stdin.readline().split())
    graph[x].append((z, y))
    
dijkstra(start)

for i in dlist[1:]:
    print(i if i!= INF else "INF")
