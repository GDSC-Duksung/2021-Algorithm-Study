import sys
import heapq

n = int(sys.stdin.readline())
h = []

for i in range(n):
    num = int(sys.stdin.readline())
    if num == 0:
        try:
            print(-1*heapq.heappop(h))
        except:
            print(0)

    else:
        heapq.heappush(h, -num)
