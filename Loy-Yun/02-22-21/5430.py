from sys import stdin, stdout

def AC(com, li):
    left = True
    if len(li) < com.count('D'):
        return 'error\n'
    for c in com:
        if c == 'R': left = not left
        elif c == 'D':
            p = 0 if left else -1
            if li: li.pop(p)
            else: return 'error\n'
    if li:
        if left: return '[' + ','.join(li) + ']\n'
        else: return '[' + ','.join(reversed(li)) + ']\n'
    return '[]\n'

t = int(stdin.readline())

for _ in range(t):
    com = stdin.readline()
    n = stdin.readline().rstrip()
    li = stdin.readline().rstrip()[1:-1].split(',')
    if (n == 0) or (n=='0') : li = []
    stdout.write(AC(com, li))
