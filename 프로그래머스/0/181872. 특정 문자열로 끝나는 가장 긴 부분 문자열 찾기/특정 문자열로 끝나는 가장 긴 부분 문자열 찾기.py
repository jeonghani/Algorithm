def solution(myString, pat):
    answer = ''
    for i in range(len(myString)):
        target = myString[i:i+len(pat)]
        
        if len(target)!=len(pat):
            break
        if target == pat:
            answer = myString[0:i+len(pat)]
    return answer