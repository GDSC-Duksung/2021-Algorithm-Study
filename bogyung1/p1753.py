# 백준 1753번

import sys
import heapq


V, E=map(int, sys.stdin.readline().split())
INF=sys.maxsize

# 시작점
K=int(input())

# 최단경로를 가지고있는 배열, 기본값으로 INF를 가지고있게함
dp=[INF]*(V+1)

heap=[]

graph=[[]for _ in range(V+1)]

def Dijkstra(start):
    dp[start]=0
    heapq.heappush(heap, (0, start)) # dp[start]=0도 같은 의미

    while heap:
        wei, cur=heapq.heappop(heap) # 무게, 현재

        if dp[cur]<wei: # 더 짧은 경로를 발견했다면?
            continue
        # w: 가중치
        for w, next_n in graph[cur]: # cur노드에 연결된 다른 노드 탐색
            next_w=w+wei # cur부터 next_n까지의 경로

            if next_w <dp[next_n]: #next_n까지 방문한 경로보다 새로운 next_w가 짧거나
                dp[next_n]=next_w # next_n에 방문한 적이 없는 경우, dp를 갱신하고 heap에 추가
                heapq.heappush(heap, (next_w, next_n))



#간선
for _ in range(E):
    u, v, w=map(int, sys.stdin.readline().split())
    graph[u].append((w, v))


Dijkstra(K)
for i in range(1, V+1):
    print("INF" if dp[i]==INF else dp[i])