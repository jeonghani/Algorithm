def solution(food):
    answer = ''
    for i in range(1, len(food)):
        if food[i]//2 != 0:
            answer = answer+str(i)*(food[i]//2)
    rev = answer[::-1]
    answer = answer + '0' + rev
    return answer