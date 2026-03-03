import sys

input = sys.stdin.readline

N = int(input())
sentences = [input().split() for _ in range(N)]

for sentence in sentences:
    for word in sentence:
        print(word[::-1], end=" ")
    print()