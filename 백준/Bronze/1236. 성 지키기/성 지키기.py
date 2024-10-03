n, m = map(int, input().split())
array = []

for _ in range(n):
    array.append(input())

row = [0]*n
col = [0]*m

for i in range(n):
    for j in range(m):
        if array[i][j] == 'X':
            row[i] = 1
            col[j] = 1

row_cnt = 0
col_cnt = 0

for i in range(n) :
    if row[i] == 0:
        row_cnt += 1

for j in range(m) :
    if col[j] == 0:
        col_cnt += 1

print(max(row_cnt, col_cnt))