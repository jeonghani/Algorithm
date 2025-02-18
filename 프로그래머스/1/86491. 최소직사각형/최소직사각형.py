def solution(sizes):
    answer = 0
    a = 0
    b = 0
    for i in range(len(sizes)):
        sizes[i][0], sizes[i][1] = max(sizes[i][0], sizes[i][1]), min(sizes[i][0], sizes[i][1])
        if sizes[i][0] > a:
            a = sizes[i][0]
        if sizes[i][1] > b:
            b = sizes[i][1]
    return a*b