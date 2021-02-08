import sys
from collections import deque
# deque는 double-ended queue의 줄임말로 양방향에서 데이터를 처리할 수 있는
# queue형 자료구조를 의미한다.

input = sys.stdin.readline

n, m, k, x = map(int, input().split())
visited = [False] * (n+1)

path = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    path[a].append(b)

answer = list()
q = deque()
q.append((x, 0))
while q:
    town, count = q.popleft()
    if count == k :
        answer.append(town)
    elif count < k:
        for con in path[town]:
            for con in path[town]:
                if not visited[con]:
                    visited[con] = True
                    q.append((con, count + 1))

if len(answer) == 0:
    print(-1)
else:
    answer.sort()
    for ans in answer:
        print(ans)