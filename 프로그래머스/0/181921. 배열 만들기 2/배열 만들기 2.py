def solution(l, r):
    answer = []
    out = ['1', '2', '3', '4', '6', '7', '8', '9']
    
    for i in range(l, r+1):
        if all(digit in '05' for digit in str(i)):
            answer.append(i)
    if len(answer) == 0:
        answer.append(-1)
    return answer