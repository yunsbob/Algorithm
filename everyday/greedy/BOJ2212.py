N = int(input())
K = int(input())

if K >= N:
    print(0)
else:
    p = sorted(list(map(int, input().split())))
    res = []
    for i in range(1, N):
        res.append(p[i] - p[i - 1])
    res.sort(reverse=True)
    print(sum(res[K - 1:]))
