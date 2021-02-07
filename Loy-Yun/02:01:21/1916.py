from heapq import heappop, heappush
import sys

INF = 1e9

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

graph = [[] for _ in range(n+1)]
dlist = [INF] * (n+1)
for i in range(m):
    dep, arr, cost = map(int, sys.stdin.readline().split())
    graph[dep].append((cost, arr))

start, arrive = map(int, sys.stdin.readline().split())
      
def dijkstra(start, arrive):
    dlist[start] = 0
    h = []
    heappush(h, [0, start])

    while h:
        cost, city = heappop(h)

        if dlist[city] < cost:
            continue
        for c, n_city in graph[city]:
            n_cost = c+cost
            if n_cost < dlist[n_city]:
                dlist[n_city] = n_cost
                heappush(h, (n_cost, n_city))

    return dlist[arrive]

print(dijkstra(start, arrive))
