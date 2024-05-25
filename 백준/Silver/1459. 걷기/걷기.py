X, Y, W, S = map(int, input().split())

print(min((X + Y) * W, min((min(X, Y) * S) + ((max(X, Y) - min(X, Y)) * W), max(X, Y) * S if (X + Y) % 2 == 0 else (max(X, Y) - 1) * S + W)))