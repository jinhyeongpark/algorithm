import sys

input = sys.stdin.readline

N, K = map(int, input().split())
num = K-1 #초기 넘버: 2
res = []

arr = list(range(1,N+1))
for _ in range(N):
    if num >= len(arr):
        num %= len(arr)
    res.append(arr.pop(num))
    num += K-1
res = [str(n) for n in res]
print(f"<{', '.join(res)}>")