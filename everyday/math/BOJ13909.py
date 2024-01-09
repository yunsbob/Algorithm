N = int(input())

res = 0
num = 1
while num * num <= N:
	res += 1
	num += 1

print(res)