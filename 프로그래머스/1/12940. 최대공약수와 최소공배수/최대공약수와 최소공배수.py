def solution(n, m):
    answer = []
    a, b = max(n, m), min(n, m)
    while b:
        a, b = b, a%b
    answer.append(a)
    answer.append(n*m//a)
    return answer