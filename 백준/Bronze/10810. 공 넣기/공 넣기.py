N , M = list(map(int, input().split()))

basket = [0] * N

for i in range(M):
    start, end, num = list(map(int, input().split()))
    basket[start-1:end] = [num] * (end - start + 1)

for i in basket:
    print(i,end = " ")