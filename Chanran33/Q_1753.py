import sys
import heapq
#heapq 모듈은 이진트리 기반의 최소 힙 자료구조를 제공한다.

input = sys.stdin.readline
INF = sys.maxsize
V, E = map(int, input().split())

K = int(input()) #시작점
dp = [INF]*(V+1) #가중치 테이블
heap = []
graph = [[] for _ in range(V+1)]

def Dijkstra(start):
    dp[start] = 0 #정점일때 가중치 0
    heapq.heappush(heap,(0, start))

    while heap:
        weight, now = heapq.heappop(heap)

        if dp[now] < weight:
            continue

        for w, next_node in graph[now]:
            #현재 정점까지 가중치 weight + 다음 정점까지 가중치 w
            next_weight = w + weight

            if next_weight < dp[next_node]:
                dp[next_node] = next_weight
                heapq.heappush(heap,(next_weight, next_node))

for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((w,v))


Dijkstra(K)
for i in range(1,V+1):
    print("INF" if dp[i] == INF else dp[i])