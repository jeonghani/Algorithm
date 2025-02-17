def solution(a, b):
    m = max(a, b)
    n = min(a, b)
    answer = [i for i in range(n, m+1)]
    return sum(answer)