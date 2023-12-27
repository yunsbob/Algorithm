N, L = map(int, input().split())
holes = list(map(int, input().split()))
holes.sort()

res = 1
s = holes[0] - 1
e = s + L

for i in range(1, N):
    if holes[i] > e:
        res += 1
        s = holes[i] - 1
        e = s + L

print(res)