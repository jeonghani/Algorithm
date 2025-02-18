def solution(n, m, section):
    answer = 0
    section.sort()
    last = 0
    
    for i in section:
        if i<=last :
            continue
        answer+=1
        last = i+m-1
    return answer