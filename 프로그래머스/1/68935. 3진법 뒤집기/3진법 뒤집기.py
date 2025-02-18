def solution(n):
    answer = []
    while n>0:
        answer.append(n%3)
        n = n//3
    
    answer = ''.join(map(str, answer))
    return int(answer, 3)