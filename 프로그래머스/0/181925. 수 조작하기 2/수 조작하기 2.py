def solution(numLog):
    answer = ''
    prev = numLog[0]
    
    for i in range(1, len(numLog)):
        if prev + 1 == numLog[i]:
            answer+='w'
        elif prev - 1 == numLog[i]:
            answer+='s'
        elif prev + 10 == numLog[i]:
            answer+='d'
        else:
            answer+='a'
        prev=numLog[i]
    return answer