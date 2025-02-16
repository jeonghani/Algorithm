def solution(n):
    arr = [[0] * n for i in range(n)]

    cnt = 1

    start_row = 0
    end_row = n - 1
    start_col = 0
    end_col = n - 1

    while cnt <= n * n:
        for i in range(start_col, end_col + 1):
            arr[start_row][i] = cnt
            cnt += 1
        start_row += 1

        for i in range(start_row, end_col + 1):
            arr[i][end_col] = cnt
            cnt += 1
        end_col -= 1

        for i in range(end_col, start_col - 1, -1):
            arr[end_row][i] = cnt
            cnt += 1
        end_row -= 1

        for i in range(end_row, start_row - 1, -1):
            arr[i][start_col] = cnt
            cnt += 1
        start_col += 1

    return arr