def solution(strArr):
    answer = strArr
    for i in range(len(answer)):
        if i%2==1:
            answer[i] = answer[i].upper()
        else:
            answer[i] = answer[i].lower()
    return answer