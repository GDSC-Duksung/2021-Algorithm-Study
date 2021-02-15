# 최대 힙 = 최대 트리, 완전 이진 트리
import heapq # heapq는 min heap만 지원, x를 음수로 만들어줘 최대값을 출력한다.
from sys import stdin
n=int(input()) # 13
heap=[]

# 원소 추가
for _ in range(n):
    x = int(stdin.readline()) # 원소 추가
    if x==0:
        if heap:
            print(-1*heapq.heappop(heap))
        else:
            print("0")
    else:
        heapq.heappush(heap, (-x))
