N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
left = [0 for _ in range(N)]
right = [0 for _ in range(N)]
dp = [300 for _ in range(N)]
arr.sort()

for i in range(N):
    x = arr[i][0] + arr[i][1]
    idx = i
    while True:
        if idx == N:
            for j in range(i + 1, idx):
                right[j] = idx - 1
            i = idx
            break
        if x >= arr[idx][0]:
            right[i] = idx
            x = max(x, arr[idx][0] + arr[idx][1])
            idx += 1
        else:
            for j in range(i + 1, idx):
                right[j] = idx - 1
            i = idx - 1
            break

for i in range(N - 1, -1, -1):
    x = arr[i][0] - arr[i][1]
    idx = i
    while True:
        if idx == -1:
            for j in range(i - 1, idx):
                right[j] = idx + 1
            i = idx
            break
        if x <= arr[idx][0]:
            left[i] = idx
            x = min(x, arr[idx][0] - arr[idx][1])
            idx -= 1
        else:
            for j in range(i - 1, idx):
                left[j] = idx + 1
            i = idx + 1
            break

for i in range(N):
    if left[i] == 0: dp[i] = 1
    else:
        dp[i] = dp[left[i] - 1] + 1

        if right[0] == i: dp[i] = 1
        else:
            for j in range(1, i):
                if right[j] >= i:
                    dp[i] = min(dp[i], dp[j - 1] + 1)

print(dp[N - 1])