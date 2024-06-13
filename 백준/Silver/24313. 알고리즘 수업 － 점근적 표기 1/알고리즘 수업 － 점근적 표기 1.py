a, b = map(int, input().split())
c = int(input())
n = int(input())

print(1 if (a * n + b) <= (c * n) and a <= c else 0)