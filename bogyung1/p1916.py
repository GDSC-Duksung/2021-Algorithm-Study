import sys
import heapq



n=int(input())
m=int(input())
INF=sys.maxsize

dp=[INF]*(n+1)
graph=[[]for _ in range(n+1)]

for i in range(m):
    a, b, w = map(int, sys.stdin.readline().split())
    graph[a].append([b, w])
start, end=map(int,sys.stdin.readline().split())




def Dijkstra(start):
    dp[start]=0
    heap=[]
    heapq.heappush(heap, [0, start]) # dp[start]=0도 같은 의미

    while heap:
        wei, cur=heapq.heappop(heap) # 무게, 현재

        if dp[cur]<wei: # 더 짧은 경로를 발견했다면?
            continue
        # w: 가중치
        for  next_n,w in graph[cur]: # cur노드에 연결된 다른 노드 탐색
            next_w=w+wei # cur부터 next_n까지의 경로

            if next_w <dp[next_n]: #next_n까지 방문한 경로보다 새로운 next_w가 짧거나
                dp[next_n]=next_w # next_n에 방문한 적이 없는 경우, dp를 갱신하고 heap에 추가
                heapq.heappush(heap, [next_w, next_n])

Dijkstra(start)
print(dp[end])