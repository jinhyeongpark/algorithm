from sys import stdin
T = int(stdin.readline())
ansList = []
for i in range(T):
    xy = list(map(int, stdin.readline().split()))
    distance = xy[1]- xy[0]
    ans, min = 0, 1
    while distance > 0:
        distance -= min
        ans += 1
        if ans % 2 == 0:
            min += 1
    ansList.append(ans)
for e in ansList:
    print(e)