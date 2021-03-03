import math
import sys

t = int(sys.stdin.readline())
s = []
a = []
gcd = 0

for i in range(t):
    s.append(int(sys.stdin.readline()()))
    if i == 1:
        gcd = abs(s[1] - s[0])
    gcd = math.gcd(abs(s[i] - s[i - 1]), gcd)
    
gcd_a = int(gcd ** 0.5)

for i in range(2, gcd_a + 1):
    if gcd % i == 0:
        a.append(i)
        a.append(gcd // i)
        
a.append(gcd)
a = list(set(a))
a.sort()

for i in a:
    print(i, end = ' ')
